package org.lk.service.converter;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.WaterEntity;
import org.lk.model.dto.WaterDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WaterConverter implements Converter<WaterEntity, WaterDto> {

    private final ModelMapper modelMapper;

    @Override
    public WaterEntity toEntity(WaterDto dto) {
        return modelMapper.map(dto, WaterEntity.class);
    }

    @Override
    public WaterDto toDto(WaterEntity entity) {
        return modelMapper.map(entity, WaterDto.class);
    }

}
