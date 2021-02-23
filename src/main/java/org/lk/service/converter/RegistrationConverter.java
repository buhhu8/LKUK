package org.lk.service.converter;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.lk.model.dto.RegistrationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrationConverter implements Converter<RegistrationDto, Object> {

    ModelMapper modelMapper;

    @Override
    public RegistrationDto toEntity(Object dto) {
        return modelMapper.map(dto,RegistrationDto.class);
    }

    @Override
    public Object toDto(RegistrationDto entity) {
        return modelMapper.map(entity, Object.class);
    }
}
