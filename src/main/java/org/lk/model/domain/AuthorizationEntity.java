package org.lk.model.domain;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "user_authorization")

public class AuthorizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;


    @OneToOne
    @JoinColumn(name = "user_id")
    private InfoEntity authInfo;





}

