package org.lk.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthorizationRequest {

    private Integer id;
    private String login;
    private String password;

}
