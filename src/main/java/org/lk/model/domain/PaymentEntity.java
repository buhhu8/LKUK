package org.lk.model.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "payment")

public class PaymentEntity {

    @Id
    private Integer id;
    private String debt;
    private LocalDate paymentDate;
}
