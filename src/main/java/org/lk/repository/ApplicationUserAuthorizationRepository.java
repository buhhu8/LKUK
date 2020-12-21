package org.lk.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lk.model.domain.UserAuthorizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationUserAuthorizationRepository {

    private final SessionFactory factory;

    @Autowired
    public ApplicationUserAuthorizationRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public List<UserAuthorizationEntity> findById(Integer id) {
        List<UserAuthorizationEntity> result = null;

        try (Session session = factory.openSession()) {

            result = session.createQuery("from UserAuthorizationEntity where id = :id", UserAuthorizationEntity.class)
                    .setParameter("id", id)
                    .getResultList();
        }
        if (result.isEmpty()) {
            result = null;
        }
        return result;

    }
}
