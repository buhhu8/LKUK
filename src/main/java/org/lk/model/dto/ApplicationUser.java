package org.lk.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ApplicationUser {

    private Integer id;
    private String login;
    private String last_name;
    private String first_name;
    private Date birthDate;

}
