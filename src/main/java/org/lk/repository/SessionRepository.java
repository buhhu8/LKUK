package org.lk.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lk.model.domain.SessionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.sql.Date;

@Repository
public class SessionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public SessionRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
