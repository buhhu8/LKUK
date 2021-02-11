package org.lk.model.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "user_authorization")

public class AuthorizationEntity {

    @Id
    @Column(name = "user_id", unique = true)
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

}

