package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.PaymentDto;
import org.lk.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user/")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/insertpay")
    public void insertIntoPayment(@RequestBody PaymentDto dto) {
        // PaymentDto dto = new PaymentDto();
        // new PaymentDto.PaymentDtoBuilder(); // object of nested class
        // new PaymentDto().new PaymentDtoBuilder(); // object of inner class
       // PaymentDto.builder()


//        PaymentDto.builder()
//                .userId(1)
//                .debt("sad")
//                .paymentDate()
//                .id(1)
//                .build();
        paymentService.insertIntoPayment("234");


    }

}
