package org.lk.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class InfoDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String flat;
    private String someInfo;

}
