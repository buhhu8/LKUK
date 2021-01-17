package org.lk.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lk.model.domain.AuthorizationSessionEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserAuthorizationSessionRepository {

    private final SessionFactory sessionFactory;

    public void saveSessionId(Integer id, String sessionId, LocalDate expiredDate){

        try(Session session = sessionFactory.openSession()){

            Transaction tx = session.beginTransaction();
//            LocalDateTime.now()
//                    .atZone(ZoneId.systemDefault())
//                    .toInstant()
//                    .toEpochMilli();

            AuthorizationSessionEntity s = new AuthorizationSessionEntity(id, sessionId, expiredDate);
            session.saveOrUpdate(s);
            tx.commit();

        }

    }

    public Optional<AuthorizationSessionEntity> findBySessionId(String id){
        try (Session session = sessionFactory.openSession()) {
            List<AuthorizationSessionEntity> sessions = session.createQuery("from AuthorizationSessionEntity where sessionId = :id", AuthorizationSessionEntity.class)
                    .setParameter("id", id)
                    .getResultList();
            return sessions.isEmpty() ? Optional.empty() : Optional.ofNullable(sessions.get(0));
        }
    }

}
