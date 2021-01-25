package org.lk.repository.jpa;

import org.lk.model.domain.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface JpaUserInfoRepository
        extends JpaRepository<InfoEntity, Integer> {

    Optional<InfoEntity> findByFlat(String flat);

    Collection<InfoEntity> findAllByFirstNameAndLastName(String firstName, String lastName);

    Optional<InfoEntity> findById(Integer id);

    @Query(
            nativeQuery = true,
            value = "select * from userinfo where middle_name = :middleName"
    )
    Collection<InfoEntity> findUsers(@Param("middleName") String middleName);

}
