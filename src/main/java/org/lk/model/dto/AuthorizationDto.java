package org.lk.model.dto;

import lombok.Data;

@Data
public class AuthorizationDto {

    private Integer id;
    private String login;
    private String password;

}
