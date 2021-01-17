package org.lk.repository.jpa;

import org.apache.catalina.User;
import org.lk.model.domain.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface JpaUserAuthorizationSessionRepository
        extends JpaRepository<UserInfoEntity, Integer> {

    Optional<UserInfoEntity> findByFlat(String flat);

    Collection<UserInfoEntity> findAllByFirstNameAndLastName(String firstName, String lastName);

    @Query(
            nativeQuery = true,
            value = "select * from userinfo where middle_name = :middleName"
    )
    Collection<UserInfoEntity> findUsers(@Param("middleName") String middleName);

}
