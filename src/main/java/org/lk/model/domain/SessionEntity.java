package org.lk.model.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "authorization_session")
public class SessionEntity {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "expired_date")
    private LocalDate authorizationExpiredDate;

}
