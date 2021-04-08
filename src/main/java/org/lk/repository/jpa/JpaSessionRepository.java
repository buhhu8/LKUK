package org.lk.repository.jpa;

import org.lk.model.domain.SessionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JpaSessionRepository
        extends CrudRepository<SessionEntity, Integer> {

    Optional<SessionEntity> findBySessionId(String sessionId);

}
