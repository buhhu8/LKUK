package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.model.domain.UserAuthorizationEntity;
import org.lk.repository.ApplicationUserAuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthorizationUserService {


    private final ApplicationUserAuthorizationRepository repository;

    @Autowired
    public AuthorizationUserService(ApplicationUserAuthorizationRepository repository) {
        this.repository = repository;
    }

    public boolean authorizeUser(Integer id, String password){

        String hash;
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (id < 1 || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Id or password couldn't be blank");
        }

        UserAuthorizationEntity user = repository.findById(id);
        hash = passwordEncoder.encode(password);
        System.out.println(hash);
        return user != null && passwordEncoder.matches(password,user.getPassword());

    }


}
