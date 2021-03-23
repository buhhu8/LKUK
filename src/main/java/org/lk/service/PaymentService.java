package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.PaymentEntity;
import org.lk.model.dto.PaymentDto;
import org.lk.repository.jpa.JpaPaymentRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                .paymentInfo(jpaUserInfoRepository.getOne(userId)) // TODO
                .build();
        jpaPaymentRepositorytRepository.save(modelMapper.map(paymentDto, PaymentEntity.class));
    }

    public List<PaymentDto> showAllPaymentByUserId(Integer userId){
        List<PaymentEntity> list =  jpaPaymentRepositorytRepository.findAllByUserId(userId);
        List<PaymentDto> list1 = new ArrayList<>();
        for (PaymentEntity entity : list){
            list1.add(modelMapper.map(entity,PaymentDto.class));
        }
        return list1;
    }

    public PaymentDto showPaymentByUserIdAndDate(Integer userId, Date date){
        return jpaPaymentRepositorytRepository.findByUserIdAndDate(userId,date)
                .map(entity ->  modelMapper.map(entity, PaymentDto.class))
                .orElseThrow(() -> new RuntimeException("Couldn't find records")) ;
    }

}