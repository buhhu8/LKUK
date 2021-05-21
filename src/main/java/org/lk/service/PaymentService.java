package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.PaymentEntity;
import org.lk.model.dto.InfoDto;
import org.lk.model.dto.PaymentDto;
import org.lk.repository.jpa.JpaPaymentRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final JpaPaymentRepository jpaPaymentRepositorytRepository;
    private final JpaUserInfoRepository jpaUserInfoRepository;
    private final ModelMapper modelMapper;

    public void insertIntoPayment(Integer userId, String debt) {
        PaymentDto paymentDto = PaymentDto.builder()
                .paymentDate(LocalDate.now())
                .debt(debt)
                .paymentInfo(modelMapper.map(jpaUserInfoRepository.getOne(userId), InfoDto.class))
                .build();
        jpaPaymentRepositorytRepository.save(modelMapper.map(paymentDto, PaymentEntity.class));
    }

    public List<PaymentDto> showAllPaymentByUserId(Integer userId){
        List<PaymentEntity> list =  jpaPaymentRepositorytRepository.findAllByUserId(userId);
        return list.stream()
                .map(entity -> modelMapper.map(entity,PaymentDto.class))
                .collect(Collectors.toList());
    }

    public PaymentDto showPaymentByUserIdAndDate(Integer userId, Date date){
        return jpaPaymentRepositorytRepository.findByUserIdAndDate(userId,date)
                .map(entity ->  modelMapper.map(entity, PaymentDto.class))
                .orElseThrow(() -> new RuntimeException("Couldn't find records")) ;
    }

}