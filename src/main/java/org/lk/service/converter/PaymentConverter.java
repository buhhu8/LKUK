package org.lk.service.converter;

import lombok.AllArgsConstructor;
import org.lk.model.domain.PaymentEntity;
import org.lk.model.dto.PaymentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentConverter implements Converter<PaymentEntity, PaymentDto> {

    private final ModelMapper modelMapper;

    @Override
    public PaymentEntity toEntity(PaymentDto dto) {
        return modelMapper.map(dto,PaymentEntity.class);
    }

    @Override
    public PaymentDto toDto(PaymentEntity entity) {
        return modelMapper.map(entity,PaymentDto.class);
    }

}
