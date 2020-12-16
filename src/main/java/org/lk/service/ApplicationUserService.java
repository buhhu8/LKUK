package org.lk.service;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        String hash;
        PasswordEncoder passwordEnocder = new BCryptPasswordEncoder();
        if (!StringUtils.hasLength(login) || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Login or password couldn't be blank");
        }

        ApplicationUserEntity user = repository.findUserByLogin(login);
        hash = passwordEnocder.encode(password);
        System.out.println(hash);

        return user != null && passwordEnocder.matches(password,user.getPassword());

    }

}
