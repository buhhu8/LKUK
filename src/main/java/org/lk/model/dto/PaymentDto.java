package org.lk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.lk.model.domain.InfoEntity;

import java.time.LocalDate;

@Getter
public class PaymentDto {

    private PaymentDto(){ }

    private String debt;
    private Integer userId;
    private LocalDate paymentDate;
    private InfoEntity paymentInfo;

    public static PaymentBuilder builder() {
        return new PaymentDto().new PaymentBuilder();
    }

    public class PaymentBuilder {

        public PaymentBuilder paymentInfo(InfoEntity paymentInfo){
            PaymentDto.this.paymentInfo = paymentInfo;
            return this;

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