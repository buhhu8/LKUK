package org.lk.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.lk.model.domain.InfoEntity;

import java.time.LocalDate;

@Getter
@Setter
public class PaymentDto {

    private String debt;
    private Integer userId;
    private LocalDate paymentDate;
    private InfoEntity paymentInfo;
    private PaymentDto() {
    }

    public static PaymentBuilder builder() {
        return new PaymentDto().new PaymentBuilder();
    }

    public class PaymentBuilder {

        public PaymentBuilder paymentInfo(InfoEntity paymentInfo) {
            PaymentDto.this.paymentInfo = paymentInfo;
            return this;

        }

        public PaymentBuilder debt(String debt) {
            PaymentDto.this.debt = debt;
            return this;
        }

        public PaymentBuilder paymentDate(LocalDate date) {
            PaymentDto.this.paymentDate = date;
            return this;
        }

        public PaymentDto build() {
            return PaymentDto.this;
        }

    }


}