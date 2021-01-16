package org.lk.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String flat;

}
