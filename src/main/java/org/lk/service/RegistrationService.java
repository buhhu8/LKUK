package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.AuthorizationDto;
import org.lk.model.dto.InfoDto;
import org.lk.model.dto.RegistrationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final JpaUserAuthorizationRepository jpaUserAuthorizationRepository;
    private final JpaUserInfoRepository jpaUserInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void register(RegistrationDto registrationDto) {
        saveAuthInfo(registrationDto);
    }

    public void saveAuthInfo(RegistrationDto registrationDto) {
        String password = passwordEncoder.encode(registrationDto.getPassword());
        InfoDto infoDto = InfoDto.builder()
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .middleName(registrationDto.getMiddleName())
                .flat(registrationDto.getFlat())
                .build();
        InfoEntity info = jpaUserInfoRepository.save(modelMapper.map(infoDto,InfoEntity.class));
        AuthorizationDto authorizationDto = AuthorizationDto.builder()
                .authInfo(info)
                .login(registrationDto.getLogin())
                .password(password)
                .build();
        jpaUserAuthorizationRepository.save(modelMapper.map(authorizationDto, AuthorizationEntity.class));
    }
}
