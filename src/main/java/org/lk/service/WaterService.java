package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.WaterEntity;
import org.lk.model.dto.WaterDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.repository.jpa.JpaWaterRepository;
import org.lk.service.converter.WaterConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final JpaWaterRepository jpaWaterRepository;
    private final WaterConverter waterConverter;
    private final JpaUserInfoRepository userInfoRepository;

    public WaterDto finById(Integer userId) {

        return waterConverter.toDto(jpaWaterRepository.findByUserId(userId).get());

    }

    public void insertWater(Integer userId, String hot, String cold, LocalDate date) {
        WaterEntity waterEntity = new WaterEntity();

        waterEntity.setHot(hot);
        waterEntity.setCold(cold);
        waterEntity.setDateWater(date);
        waterEntity.setUserInfo(userInfoRepository.getOne(userId)); // не ходит в базу

        jpaWaterRepository.save(waterEntity);
    }

}
