package org.lk.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WaterDto {

    private Integer id;
    private Integer userId;
    private String hot;
    private String cold;
    @JsonProperty("date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateWater;

}
