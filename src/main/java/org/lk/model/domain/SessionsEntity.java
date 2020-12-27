package org.lk.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Table(name= "sessions")
public class SessionsEntity {

    @Id
    Integer id;
    String cookie;
    LocalDate dateexperience; // TODO: convert to LocalDateTime

}
