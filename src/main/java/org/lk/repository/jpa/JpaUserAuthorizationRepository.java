package org.lk.repository.jpa;

import org.lk.model.domain.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserAuthorizationRepository
        extends JpaRepository<AuthorizationEntity, Integer> {

    Optional<AuthorizationEntity> findById(Integer id);
}
