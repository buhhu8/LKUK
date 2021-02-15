package org.lk.repository.jpa;

import org.lk.model.domain.WaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaWaterRepository extends JpaRepository<WaterEntity, Integer> {

    @Query(
            value = "select * from water where user_id = :userId",
            nativeQuery = true
    )
    Optional<WaterEntity> findByUserId(@Param("userId") Integer userId);

}
