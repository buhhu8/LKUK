package org.lk.service;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {

    private final ApplicationUserRepository repository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository repository) {
        this.repository = repository;
    }


    public boolean authorizeUser(Integer id) {

        ApplicationUserEntity user = repository.findUserById(id).get(0);

        return user != null;

    }

}
