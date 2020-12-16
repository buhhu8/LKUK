package org.lk.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user_authorization_table")
public class UserAuthorizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;


}
