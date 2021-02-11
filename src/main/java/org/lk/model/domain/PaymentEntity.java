package org.lk.model.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
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
    @Column(name = "user_id")
    private Integer user_id;
    private Integer id;
    private String debt;
    private LocalDate paymentDate;
}
