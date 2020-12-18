package org.lk.model.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
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

    @Override
    public String toString() {
        return "ApplicationUserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

