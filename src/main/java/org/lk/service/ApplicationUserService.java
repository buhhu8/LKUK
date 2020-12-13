package org.lk.service;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ApplicationUserService {

    private final ApplicationUserRepository repository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    public boolean authorizeUser(String login, String password) {
        if (!StringUtils.hasLength(login) || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Login or password couldn't be blank");
        }

        ApplicationUserEntity user = repository.findUserByLogin(login);
        return user != null && user.getPassword().equals(password);
    }

}
