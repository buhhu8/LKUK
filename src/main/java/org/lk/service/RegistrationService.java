package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoDto;
import org.lk.model.dto.RegistrationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.service.converter.InfoConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final JpaUserAuthorizationRepository jpaUserAuthorizationRepository;
    private final JpaUserInfoRepository jpaUserInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final InfoConverter infoConverter;

    public void saveAuthInfo(Integer id, String login, String password) {
        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setUserId(id);
        authorizationEntity.setLogin(login);
        authorizationEntity.setPassword(passwordEncoder.encode(password));
        jpaUserAuthorizationRepository.save(authorizationEntity);

    }

    public InfoDto saveInfo(RegistrationDto registration) {
        // validation

        InfoEntity infoEntity = new InfoEntity(registration.getFirstName(), registration.getLastName(),
                registration.getMiddleName(), registration.getFlat());

        jpaUserInfoRepository.save(infoEntity);

        return infoConverter.toDto(infoEntity);
    }

}
