package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.WaterEntity;
import org.lk.model.dto.WaterDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.repository.jpa.JpaWaterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final JpaWaterRepository jpaWaterRepository;
    private final ModelMapper modelMapper;
    private final JpaUserInfoRepository userInfoRepository;

    public WaterDto finById(Integer userId) {
        WaterEntity entity = jpaWaterRepository.findByUserId(userId).get();
        return modelMapper.map(entity,WaterDto.class);
    }

    public String findAllWaterById(Integer userId) {
        List<WaterEntity> list = jpaWaterRepository.findAll();
        list.forEach(employee -> System.out.println(employee.toString()));

        return "as";
    }

    public void insertWater(Integer userId, String hot, String cold) {
        WaterEntity waterEntity = new WaterEntity();
        waterEntity.setHot(hot);
        waterEntity.setCold(cold);
        waterEntity.setDateWater(LocalDate.now());
        waterEntity.setUserInfo(userInfoRepository.getOne(userId)); // не ходит в базу
        jpaWaterRepository.save(waterEntity);
    }

}
