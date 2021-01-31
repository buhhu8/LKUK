package org.lk.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InfoAndAuthDto {

    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String flat;
    private String someInfo;
    private String sessionId;
    private LocalDate authorizationExpiredDate;

}
