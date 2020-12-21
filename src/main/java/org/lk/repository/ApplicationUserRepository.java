package org.lk.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lk.model.domain.ApplicationUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ApplicationUserRepository {

    private final SessionFactory factory;

    @Autowired
    public ApplicationUserRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public List<ApplicationUserEntity> findUserById(Integer id) {
        List<ApplicationUserEntity> result = null;

        try (Session session = factory.openSession()) {

            result = session.createQuery("from ApplicationUserEntity where id = :id", ApplicationUserEntity.class)
                    .setParameter("id", id)
                    .getResultList();

        } catch (NoResultException exc) {

        }

        if (result.isEmpty())
        {
            result=null;
        }

        return result;
    }


}
