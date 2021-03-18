package org.lk.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "water")
@Data
public class WaterEntity {

    //@Id
    //@Column(name = "user_id")
    //private Integer userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hot")
    private String hot;
    @Column(name = "cold")
    private String cold;
    @Column(name = "datewater")
    private LocalDate dateWater;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private InfoEntity userInfo;

}
