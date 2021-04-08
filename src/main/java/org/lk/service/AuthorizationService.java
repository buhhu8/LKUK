package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.AuthorizationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JpaUserAuthorizationRepository jpaUserAuthorizationRepository;

    public Boolean checkAuthorization(String login, String password) {
            AuthorizationDto authorizationDto = jpaUserAuthorizationRepository.findByLogin(login)
                    .map(entity -> modelMapper.map(entity, AuthorizationDto.class))
                    .orElseThrow(() -> new RuntimeException("User not found with login " + login));
            return authorizationDto.getLogin().equals(login)
                    && passwordEncoder.matches(password, authorizationDto.getPassword());
    }

    public Integer returnId(String login) {
        return jpaUserAuthorizationRepository.findByLogin(login).get().getAuthInfo().getInfoUserId();
    }


}
