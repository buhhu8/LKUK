package org.lk.service.converter;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.AuthorizationSessionEntity;
import org.lk.model.dto.SessionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionConverter implements Converter<AuthorizationSessionEntity, SessionDto> {

    private final ModelMapper modelMapper;

    @Override
    public AuthorizationSessionEntity toEntity(SessionDto dto) {
        return modelMapper.map(dto, AuthorizationSessionEntity.class);
    }

    @Override
    public SessionDto toDto(AuthorizationSessionEntity entity) {
        return modelMapper.map(entity, SessionDto.class);
    }

}
