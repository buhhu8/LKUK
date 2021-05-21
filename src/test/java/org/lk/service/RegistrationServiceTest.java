package org.lk.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lk.model.dto.RegistrationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RegistrationServiceTest {

    @Mock
    private JpaUserAuthorizationRepository jpaUserAuthorizationRepository;
    @Mock
    private JpaUserInfoRepository jpaUserInfoRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private RegistrationService registrationService;

    @Test
    void register() {
        RegistrationDto registrationDto = createDto();
        registrationService.register(registrationDto);
        verify(registrationService).saveAuthInfo(registrationDto);


    }

    @Test
    void saveAuthInfo() {
    }

    public RegistrationDto createDto(){
        return RegistrationDto.builder()
                .login("admin")
                .firstName("Denis")
                .flat("376")
                .lastName("Dorofeev")
                .middleName("Aleksandrovich")
                .password("admin")
                .build();
    }

}

