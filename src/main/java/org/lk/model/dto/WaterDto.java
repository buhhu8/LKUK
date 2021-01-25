package org.lk.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@Getter
public class WaterDto {

    private Integer id;
    private String hot;
    private String cold;
    private LocalDate dateWater;

}
