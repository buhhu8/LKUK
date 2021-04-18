package org.lk.repository.jpa;

import org.lk.model.domain.WaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaWaterRepository
        extends JpaRepository<WaterEntity, Integer> {

    @Query(
            value = "select * from water where user_id = :userId AND datewater = :date",
            nativeQuery = true
    )
    Optional<WaterEntity> findByUserIdAndDateWater(@Param("userId") Integer userId, @Param("date") LocalDate date);
    @Query(
            value = "select * from water where user_id = :userId",
            nativeQuery = true
    )
    List<WaterEntity> findAllById(@Param("userId") Integer userId);

}
