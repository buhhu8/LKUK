package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.PaymentDto;
import org.lk.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payment/")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/insert") // TODO
    public void insertIntoPayment(@RequestBody PaymentDto dto) {
        paymentService.insertIntoPayment(dto.getUserId(),dto.getDebt());
    }

}
