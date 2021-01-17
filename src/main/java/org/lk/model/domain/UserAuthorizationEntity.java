package org.lk.model.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "user_authorization_table")
public class UserAuthorizationEntity {

    @Id
    private Integer id;
    private String login;
    private String password;


}
