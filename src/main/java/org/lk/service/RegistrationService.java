package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoAndAuthDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final JpaUserAuthorizationRepository jpaUserAuthorizationRepository;
    private final JpaUserInfoRepository jpaUserInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveAuthInfo(Integer id, String login, String password) {
        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setId(id);
        authorizationEntity.setLogin(login);
        authorizationEntity.setPassword(passwordEncoder.encode(password));
        jpaUserAuthorizationRepository.save(authorizationEntity);

    }

    public void saveInfo(String firstName, String lastName, String middleName, String flat) {
        InfoEntity infoEntity = new InfoEntity();
        infoEntity.setFirstName(firstName);
        infoEntity.setLastName(lastName);
        infoEntity.setMiddleName(middleName);
        infoEntity.setFlat(flat);
        jpaUserInfoRepository.save(infoEntity);

    }

}
