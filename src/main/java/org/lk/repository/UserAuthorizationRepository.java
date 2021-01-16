package org.lk.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lk.model.domain.AuthorizationSessionEntity;
import org.lk.model.domain.UserAuthorizationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserAuthorizationRepository {

    private final SessionFactory sessionFactory;

    public UserAuthorizationEntity getLoginAndPassword(Integer id){
        UserAuthorizationEntity list=null;
        try(Session session = sessionFactory.openSession()){
            list = session.createQuery("from UserAuthorizationEntity " +
                                                                            "where id = :id",UserAuthorizationEntity.class)
                                                            .setParameter("id", id)
                                                            .getSingleResult();

        }

        return list;
    }

}
