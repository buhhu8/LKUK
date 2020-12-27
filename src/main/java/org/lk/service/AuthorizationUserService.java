package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.ApplicationUserEntity;
import org.lk.model.domain.UserAuthorizationEntity;
import org.lk.model.dto.ApplicationUser;
import org.lk.repository.ApplicationUserAuthorizationRepository;
import org.lk.repository.ApplicationUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthorizationUserService {

    private final ApplicationUserAuthorizationRepository repository;
    private final PasswordEncoder passwordEncoder;

    public boolean authorizeUser(Integer id, String password) {
        if (id < 1 || !StringUtils.hasLength(password)) {
            throw new IllegalArgumentException("Id or password couldn't be blank");
        }

        try{
            // TODO: use Optional
            UserAuthorizationEntity user = repository.findById(id).get(0);
            return passwordEncoder.matches(password, user.getPassword());
//                ApplicationUserEntity userEntity = applicationUserRepository.findUserById(id).get(0);
                // all fields from ApplicationUserEntity and put them into ApplicationUser
//                return modelMapper.map(userEntity, ApplicationUser.class);
//            }
        }
        catch (NullPointerException exc){
            return false;
        }
    }


}
