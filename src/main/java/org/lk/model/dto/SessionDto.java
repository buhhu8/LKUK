package org.lk.model.dto;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Data
@Configuration
public class SessionDto {

    private Integer userId;
    private String sessionId;
    private LocalDate authorizationExpiredDate;

}
