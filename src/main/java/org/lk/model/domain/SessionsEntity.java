package org.lk.model.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name= "sessions")
public class SessionsEntity {

    @Id
    Integer id;
    String cookie;
    Date dateexperience;



}
