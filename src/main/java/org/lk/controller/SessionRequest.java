package org.lk.controller;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SessionRequest {

    private Integer id;
    private String cookie;
    private Date dateexperience;

}
