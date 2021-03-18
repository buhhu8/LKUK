package org.lk.repository.jpa;

import org.lk.model.domain.AuthorizationSessionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JpaSessionRepository
        extends CrudRepository<AuthorizationSessionEntity, Integer> {

    Optional<AuthorizationSessionEntity> findBySessionId(String sessionId);

}
