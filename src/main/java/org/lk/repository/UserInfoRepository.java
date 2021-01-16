package org.lk.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lk.model.domain.UserInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserInfoRepository {

    private final SessionFactory sessionFactory;

    public UserInfoEntity findById(Integer id){


        try(Session session = sessionFactory.openSession()){

           return session.createQuery("from UserInfoEntity where id = :id",UserInfoEntity.class).setParameter("id", id).getSingleResult();

        }
        catch (Exception exc){
            System.out.println("Not found");
            return new UserInfoEntity();
        }
    }

}
