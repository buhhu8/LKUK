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
@Table(name  ="electricity")

public class ElectricityEntity {

    @Id
    private Integer id;
    private String dayElectricity;
    private String nightElectricity;
    private LocalDate electricityDate;



}
