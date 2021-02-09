package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.WaterDto;
import org.lk.repository.jpa.JpaWaterRepository;
import org.lk.service.converter.WaterConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final JpaWaterRepository jpaWaterRepository;
    private final WaterConverter waterConverter;

    public WaterDto finById(Integer id) {

        return waterConverter.toDto(jpaWaterRepository.findById(id).get());

    }

}
