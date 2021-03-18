package org.lk.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Getter
@Setter
@Configuration
public class SessionDto {

    private Integer userId;
    private String sessionId;
    private LocalDate authorizationExpiredDate;

}
