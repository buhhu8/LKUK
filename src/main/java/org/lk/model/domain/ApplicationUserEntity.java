package org.lk.model.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application_user_table")
public class ApplicationUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String last_name;
    private String first_name;
    private Date birthDate;


}

