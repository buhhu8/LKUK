package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.PaymentDto;
import org.lk.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{userId}/insert") // TODO
    public void insertIntoPayment(@RequestBody PaymentDto dto, @PathVariable Integer userId) {
        paymentService.insertIntoPayment(userId,dto.getDebt());
    }

    @GetMapping("/{userId}")
    public List<PaymentDto> showAllPaymentByUserId(@PathVariable Integer userId){
        return paymentService.showAllPaymentByUserId(userId);
    }

}
