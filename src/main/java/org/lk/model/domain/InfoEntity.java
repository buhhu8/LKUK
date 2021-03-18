package org.lk.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name = "userinfo")

public class InfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer InfoUserId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "flat")
    private String flat;

    public InfoEntity(String firstName, String lastName, String middleName, String flat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.flat = flat;
    }

    @OneToMany (mappedBy = "userInfo", fetch = FetchType.LAZY)
    private Set<WaterEntity> waterEntities;

//    @OneToMany(mappedBy = "paymentInfo")
//    private Set<PaymentEntity> paymentEntities;
//
//    @OneToOne (fetch = FetchType.LAZY,mappedBy = "authInfo")
//    private AuthorizationEntity infoAuth;

}
