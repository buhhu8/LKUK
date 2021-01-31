package org.lk.repository.jpa;

import org.lk.model.domain.WaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaWaterRepository extends JpaRepository<WaterEntity, Integer> {

    Optional<WaterEntity> findById(Integer id);

}
