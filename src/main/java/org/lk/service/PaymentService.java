package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.PaymentDto;
import org.lk.repository.jpa.JpaPaymentRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.service.converter.PaymentConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final JpaPaymentRepository paymentRepository;
    private final JpaUserInfoRepository userInfoRepository;
    private final PaymentConverter converter;



    public void insertIntoPayment(String debt){

        PaymentDto paymentDto = PaymentDto.builder()
                .paymentDate()
                .debt(debt)
                .userId(3)
                .id(1)
                .build();
        //paymentRepository.save(converter.toEntity(paymentDto));
        System.out.println(converter.toEntity(paymentDto));

    }

}
