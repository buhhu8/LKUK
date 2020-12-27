package org.lk.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lk.model.domain.SessionsEntity;
import org.lk.model.dto.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.util.resources.LocaleData;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Repository
public class SessionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public SessionRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUserSession(Integer userId, String generatedSessionId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
//            LocalDateTime.now()
//                    .atZone(ZoneId.systemDefault())
//                    .toInstant()
//                    .toEpochMilli();

            LocalDate expiredDate = LocalDate.now().plusDays(1);
            SessionsEntity s = new SessionsEntity(userId, generatedSessionId, expiredDate);
            // insert into sessions values (userId, sessionId, expiredDate)
            session.persist(s);

            tx.commit();
        }
    }

    public Boolean AddCookiesIntoSessions(Integer id, String sessionCookie , Date dateexperience){
        boolean flag;
        try(Session session = sessionFactory.openSession()){

            try{
                Transaction transaction = session.beginTransaction();
                 Integer ses = session.createQuery("update SessionsEntity set id = :id, cookie = :sessionCookie, dateexperience = :dateexperience where  id = :id")
                        .setParameter("id",id)
                         .setParameter("sessionCookie", sessionCookie)
                         .setParameter("dateexperience", dateexperience)
                        .executeUpdate();
                 flag = true;
                 transaction.commit();
                session.close();

            }
            catch (NoResultException exc){
                flag=false;
            }

        }

        return flag;
    }

    public Optional<SessionsEntity> findBySessionId(String sessionId) {
        try (Session session = sessionFactory.openSession()) {
            List<SessionsEntity> sessions = session.createQuery("from SessionsEntity where cookie = :sessionId", SessionsEntity.class)
                    .setParameter("sessionId", sessionId)
                    .getResultList();
            return sessions.isEmpty() ? Optional.empty() : Optional.ofNullable(sessions.get(0));
        }
    }

    public SessionsEntity checkCookieSession(Integer id){
        SessionsEntity result;
        try (Session session = sessionFactory.openSession()){

            try {
                result = session.createQuery(" from SessionsEntity where id = :id", SessionsEntity.class)
                        .setParameter("id", id)
                        .getSingleResult();

            }
            catch (NoResultException exc){
                result = null;
            }

        }
        return result;
    }

}
