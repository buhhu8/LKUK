package org.lk.service;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.model.domain.UserAuthorizationEntity;
import org.lk.repository.ApplicationUserAuthorizationRepository;
import org.lk.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthorizationUserService {


    private final ApplicationUserAuthorizationRepository repository;
    private final ApplicationUserRepository repository1;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    public AuthorizationUserService(ApplicationUserAuthorizationRepository repository, ApplicationUserRepository repository1) {
        this.repository = repository;
        this.repository1 = repository1;
    }


    public ApplicationUserEntity authorizeUser(Integer id, String password) {

        String hash;
        passwordEncoder = new BCryptPasswordEncoder();
        if (id < 1 || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Id or password couldn't be blank");
        }

        UserAuthorizationEntity user = repository.findById(id).get(0);
        ApplicationUserEntity user1 = repository1.findUserById(id).get(0);
        hash = passwordEncoder.encode("admin");
        System.out.println(passwordEncoder.matches("admin", hash));

//        return user != null && passwordEncoder.matches(user.getPassword(),password);
        return user1;
    }


}
