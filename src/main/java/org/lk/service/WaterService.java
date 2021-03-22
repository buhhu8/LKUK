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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final JpaWaterRepository jpaWaterRepository;
    private final ModelMapper modelMapper;
    private final JpaUserInfoRepository userInfoRepository;

    public WaterDto finWaterByDate(Integer userId, Date date) {
        WaterEntity entity = jpaWaterRepository.findByUserIdAndDateWater(userId, date).get();
        return modelMapper.map(entity,WaterDto.class);
    }

    public List<WaterDto> findAllWaterById(Integer userId) {
        List<WaterEntity> list = jpaWaterRepository.findAll();
        List<WaterDto> list1 = new ArrayList<>();
        for(WaterEntity entity: list){
            list1.add(modelMapper.map(entity, WaterDto.class));
        }
        return list1;
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
