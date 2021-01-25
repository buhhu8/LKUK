package org.lk.model.domain;

import lombok.*;

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
    private Integer id;
    private String login;
    private String password;


}

