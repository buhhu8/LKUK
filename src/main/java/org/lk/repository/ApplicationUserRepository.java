package org.lk.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lk.model.domain.ApplicationUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class ApplicationUserRepository {

    private final SessionFactory factory;

    @Autowired
    public ApplicationUserRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public ApplicationUserEntity findUserById(Integer id) {
        ApplicationUserEntity result = null;

        try (Session session = factory.openSession()) {

            result = session.createQuery("from ApplicationUserEntity where id = :id", ApplicationUserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();

        } catch (NoResultException exc) {

        }
        return result;
    }


}
