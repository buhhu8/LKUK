package org.lk.service;

import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.dto.AuthorizationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthorizationServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private JpaUserAuthorizationRepository jpaUserAuthorizationRepository;
    @InjectMocks
    private AuthorizationService authorizationService;

    @Test
    public void testCheckAuthorization_LoginAndPasswordCorrect_returnTrue(){
        //given
        AuthorizationEntity entity = createEntity();
        AuthorizationDto dto = createDto();
        String password = "admin";
        String login = "admin";

        when(jpaUserAuthorizationRepository.findByLogin(login))
                .thenReturn(Optional.of(entity));
        when(modelMapper.map(entity, AuthorizationDto.class))
                .thenReturn(dto);
        when(passwordEncoder.matches(password,dto.getPassword()))
                .thenReturn(Boolean.TRUE);
        //when
        Boolean result = authorizationService.checkAuthorization(login,password);
        //then
        assertEquals(Boolean.TRUE,result);
    }
    @Test
    public void testCheckAuthorization_LoginWrong_returnException(){
        //given
        String login = "admin";
        when(jpaUserAuthorizationRepository.findByLogin(login))
                .thenReturn(Optional.empty());
        //then
        assertThrows(RuntimeException.class, ()-> authorizationService.checkAuthorization(login,"admin"));
    }
    @Test
    public void testCheckAuthorization_LoginCorrectAndPasswordWrong_returnFalse(){
        //given
        AuthorizationDto dto = createDto();
        AuthorizationEntity entity = createEntity();
        String login = "admin";
        String password = "admin";
        when(jpaUserAuthorizationRepository.findByLogin(login))
                .thenReturn(Optional.of(entity));
        when(modelMapper.map(entity,AuthorizationDto.class))
                .thenReturn(dto);
        when(passwordEncoder.matches(password,dto.getPassword()))
                .thenReturn(Boolean.FALSE);
        //when
        Boolean result = authorizationService.checkAuthorization(login,password);
        //then
        assertEquals(Boolean.FALSE,result);
    }

//    @Test
//    public void testReturnId_LoginFound_returnInteger(){
//        //given
//        AuthorizationDto dto = createDto();
//        AuthorizationEntity entity = createEntity();
//        String login = "admin";
//        Integer expectedResult = 1;
//        when(jpaUserAuthorizationRepository.findByLogin(login))
//
//                .thenReturn(expectedResult);
//
//
//        //when
//        Integer result = authorizationService.returnId(login);
//        //then
//        assertEquals(expectedResult,result);
//    }

    @Test
    public void testReturnId_LoginNotFound_ReturnException(){
        String login = "admin";
        when(jpaUserAuthorizationRepository.findByLogin(login))
                .thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, ()-> authorizationService.returnId(login));

    }

    public AuthorizationDto createDto(){
        return AuthorizationDto.builder()
                .login("admin")
                .password("admin")
                .build();
    }
    public AuthorizationEntity createEntity(){
        AuthorizationEntity entity= new AuthorizationEntity();
        entity.setLogin("admin");
        entity.setPassword("admin");
        return entity;
    }


}