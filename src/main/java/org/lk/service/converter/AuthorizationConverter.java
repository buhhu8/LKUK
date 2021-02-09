package org.lk.service.converter;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.dto.AuthorizationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizationConverter implements Converter<AuthorizationEntity, AuthorizationDto> {

    private final ModelMapper modelMapper;

    @Override
    public AuthorizationEntity toEntity(AuthorizationDto dto) {
        return modelMapper.map(dto, AuthorizationEntity.class);
    }

    @Override
    public AuthorizationDto toDto(AuthorizationEntity entity) {
        return modelMapper.map(entity, AuthorizationDto.class);
    }

}
