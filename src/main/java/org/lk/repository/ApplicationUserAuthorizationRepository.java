package org.lk.repository;


import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lk.model.domain.UserAuthorizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository

public class ApplicationUserAuthorizationRepository {


    private final SessionFactory factory;

    @Autowired
    public ApplicationUserAuthorizationRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public UserAuthorizationEntity findById(Integer id){
        UserAuthorizationEntity result = null;

        try (Session session = factory.openSession()){

            result = session.createQuery("from user_authorization_table where id = :id", UserAuthorizationEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        catch(NoResultException exc){

        }
        return result;

    }


}
