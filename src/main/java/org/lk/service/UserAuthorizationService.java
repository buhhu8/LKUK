package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.model.domain.UserAuthorizationEntity;
import org.lk.repository.UserAuthorizationRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class UserAuthorizationService {

    private final UserAuthorizationRepository userAuthorizationRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean checkAuthorization(Integer id, String password, String login){

        if (id < 1 || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Id or password couldn't be blank");
        }

        try{
            // TODO: use Optional

            String userPassword = userAuthorizationRepository.getLoginAndPassword(id).getPassword();
            String userLogin = userAuthorizationRepository.getLoginAndPassword(id).getLogin();
            return passwordEncoder.matches(password, userPassword) && userLogin.equals(login);

        }
        catch (NullPointerException exc){
            return false;
        }

    }

}
