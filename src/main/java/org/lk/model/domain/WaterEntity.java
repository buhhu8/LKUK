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
@Table(name = "water")

public class WaterEntity {

    @Id
    private Integer id;
    private String hot;
    private String cold;
    private LocalDate dateWater;


}
