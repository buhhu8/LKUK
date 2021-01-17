package org.lk.repository.jpa;

import org.lk.model.domain.UserAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserAuthorizationRepository
        extends JpaRepository<UserAuthorizationEntity, Integer> {



}
