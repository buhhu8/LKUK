package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.model.domain.WaterEntity;
import org.lk.model.dto.WaterDto;
import org.lk.repository.jpa.JpaWaterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WaterService {

    private final JpaWaterRepository jpaWaterRepository;
    private final ModelMapper modelMapper;

    public WaterDto finById(Integer id) {
        Optional<WaterEntity> optional = jpaWaterRepository.findById(id);
        return convertToDto(optional);
    }

    public WaterDto convertToDto(Optional<WaterEntity> post) {
        WaterDto postDto = modelMapper.map(post.get(), WaterDto.class);
        return postDto;
    }

    public WaterEntity convertToEntity(WaterDto post) {
        WaterEntity postEntity = modelMapper.map(post, WaterEntity.class);
        return postEntity;
    }

}
