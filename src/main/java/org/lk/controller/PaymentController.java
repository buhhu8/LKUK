package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.PaymentDto;
import org.lk.service.PaymentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{userId}")
    public void insertIntoPayment(@PathVariable Integer userId,
                                  @RequestBody PaymentDto dto) {
        paymentService.insertIntoPayment(userId,dto.getDebt());
    }

    @GetMapping("/{userId}")
    public List<PaymentDto> showAllPaymentByUserId(@PathVariable Integer userId){
        return paymentService.showAllPaymentByUserId(userId);
    }

    @GetMapping("/{userId}/{date}")
    public PaymentDto showPaymentByuserIdAndDate(@PathVariable("userId") Integer userId,
                                              @PathVariable ("date") @DateTimeFormat(pattern = "dd-MM-yyyy")Date date){
        return paymentService.showPaymentByUserIdAndDate(userId,date);
    }

}
