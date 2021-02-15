package org.lk.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthorizationDto {

    private Integer userId;
    private String login;
    private String password;

}
