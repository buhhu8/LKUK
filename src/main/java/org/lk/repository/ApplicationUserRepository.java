package org.lk.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lk.model.domain.ApplicationUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserRepository {

    private final SessionFactory factory;

    @Autowired
    public ApplicationUserRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public ApplicationUserEntity findUserByLogin(String login) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from ApplicationUserEntity where login = :login", ApplicationUserEntity.class)
                    .setParameter("login", login)
                    .getSingleResult();
        }
    }

}
