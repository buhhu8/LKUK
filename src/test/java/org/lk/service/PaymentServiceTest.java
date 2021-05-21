package org.lk.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lk.model.domain.PaymentEntity;
import org.lk.model.dto.PaymentDto;
import org.lk.repository.jpa.JpaPaymentRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PaymentServiceTest {


    @Mock
    private JpaPaymentRepository jpaPaymentRepository;
    @Mock
    private JpaUserInfoRepository jpaUserInfoRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private PaymentService paymentService;


    @Test
    void insertIntoPayment() {
    }

    @Test
    void showAllPaymentByUserId() {
    }

    @Test
    void showPaymentByUserIdAndDate() {
        //given
        PaymentEntity entity = createEntity();
        PaymentDto expectedResult = createDto();
        Integer userId = 1;
        Date date = new Date(2021-4-8);
        when(jpaPaymentRepository.findByUserIdAndDate(userId,date))
                .thenReturn(Optional.of(entity));

        when(modelMapper.map(entity,PaymentDto.class))
                .thenReturn(expectedResult);

        //when
        PaymentDto result = paymentService.showPaymentByUserIdAndDate(userId,date);
        //then
        assertEquals(expectedResult,result);

    }

    public PaymentDto createDto(){
        return PaymentDto.builder()
                .debt("22")
                .paymentDate(LocalDate.of(2021,4,8))
                .build();
    }

    public PaymentEntity createEntity(){
        PaymentEntity entity = new PaymentEntity();
        entity.setDebt("22");
        entity.setPaymentDate(LocalDate.of(2021,4,8));
        return entity;
    }

}