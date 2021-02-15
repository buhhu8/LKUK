package org.lk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PaymentDto {

    private PaymentDto(){ }

    private Integer userId;
    private Integer id;
    private String debt;
    private LocalDate paymentDate;

    public static PaymentBuilder builder() {
        return new PaymentDto().new PaymentBuilder();
    }

    public class PaymentBuilder {

        public PaymentBuilder userId(Integer userId){
            PaymentDto.this.userId = userId;
            return this;
        }
        // setter
        public PaymentBuilder id(Integer id) {
            PaymentDto.this.id = id;
            return this; // return the same object of builder
        }
        public PaymentBuilder debt(String debt){
            PaymentDto.this.debt=debt;
            return this;
        }
        public PaymentBuilder paymentDate(){
            PaymentDto.this.paymentDate = LocalDate.now();
            return this;
        }

        public PaymentDto build() {
            return PaymentDto.this;
        }

    }


}