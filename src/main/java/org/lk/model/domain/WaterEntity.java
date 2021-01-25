package org.lk.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@Table(name = "water")
@Data
public class WaterEntity {

    @Id
    private Integer id;
    @Column(name = "hot")
    private String hot;
    @Column(name = "cold")
    private String cold;
    @Column(name = "date_statement_water")
    private LocalDate dateWater;


}
