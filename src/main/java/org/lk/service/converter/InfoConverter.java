package org.lk.service.converter;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InfoConverter implements Converter<InfoEntity, InfoDto> {

    private final ModelMapper modelMapper;

    @Override
    public InfoEntity toEntity(InfoDto dto) {
        return modelMapper.map(dto, InfoEntity.class);
    }

    @Override
    public InfoDto toDto(InfoEntity entity) {
        return modelMapper.map(entity, InfoDto.class);
    }
}
