package org.lk.repository.jpa;

import org.lk.model.domain.WaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaWaterRepository
        extends JpaRepository<WaterEntity, Integer> {

    @Query(
            value = "select * from water where user_id = :userId AND datewater = :date",
            nativeQuery = true
    )
    Optional<WaterEntity> findByUserIdAndDateWater(@Param("userId") Integer userId, @Param("date") Date date);
    List<WaterEntity> findAll();

}
