package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.exception.ValidationException;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.AuthorizationDto;
import org.lk.model.dto.InfoDto;
import org.lk.model.dto.RegistrationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.service.converter.AuthorizationConverter;
import org.lk.service.converter.InfoConverter;
import org.lk.service.validation.RegistrationValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final JpaUserAuthorizationRepository jpaUserAuthorizationRepository;
    private final JpaUserInfoRepository jpaUserInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorizationConverter authorizationConverter;
    private final InfoConverter infoConverter;
    private final RegistrationValidator registrationValidator;


    public boolean register(RegistrationDto registrationDto) {
        try {
            registrationValidator.validate(registrationDto);
            saveAuthInfo(registrationDto);
            return true;
        } catch (ValidationException exc) {
            return false;
        }

    }

    public void saveAuthInfo(RegistrationDto registrationDto) {
        String password = passwordEncoder.encode(registrationDto.getPassword());
        InfoDto infoDto = InfoDto.builder()
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .middleName(registrationDto.getMiddleName())
                .flat(registrationDto.getFlat())
                .build();

        InfoEntity info = jpaUserInfoRepository.save(infoConverter.toEntity(infoDto));

        AuthorizationDto authorizationDto = AuthorizationDto.builder()
                .authInfo(info)
                .login(registrationDto.getLogin())
                .password(password)
                .build();

        jpaUserAuthorizationRepository.save(authorizationConverter.toEntity(authorizationDto));


    }


}
