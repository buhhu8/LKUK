package org.lk.service;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.model.domain.UserAuthorizationEntity;
import org.lk.repository.ApplicationUserAuthorizationRepository;
import org.lk.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthorizationUserService {

    private final ApplicationUserAuthorizationRepository repository;
    private final ApplicationUserRepository repository1;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthorizationUserService(ApplicationUserAuthorizationRepository repository, ApplicationUserRepository repository1,
                                    PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.repository1 = repository1;
        this.passwordEncoder = passwordEncoder;
    }

    public ApplicationUserEntity authorizeUser(Integer id, String password) {
        ApplicationUserEntity user1;
        if (id < 1 || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Id or password couldn't be blank");
        }
        try{
            UserAuthorizationEntity user = repository.findById(id).get(0);
            if (passwordEncoder.matches(password, user.getPassword())) {
                user1 = repository1.findUserById(id).get(0);


            } else {
                user1 = null;
            }    
        }
        catch (NullPointerException exc){
            user1=null;
        }
        

        return user1;
    }


}
