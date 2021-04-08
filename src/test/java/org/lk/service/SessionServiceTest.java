package org.lk.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lk.model.domain.SessionEntity;
import org.lk.model.dto.SessionDto;
import org.lk.repository.jpa.JpaSessionRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SessionServiceTest {

    @Mock
    private ModelMapper modelMapper;
    @Mock
    private JpaSessionRepository jpaSessionRepository;


    @InjectMocks
    private SessionService sessionService;



    @Test
    void testSaveSessionId_idFound_returnString() {

        SessionEntity entity = createEntity();
        SessionDto dto = new SessionDto();
        Integer expectedResult  = 1;
        when(modelMapper.map(dto, SessionEntity.class))
                .thenReturn(entity);

        String result = sessionService.saveSessionId(1);
        assertEquals(expectedResult,result);


    }

    @Test
    public void testGenerateSessionId_returnString() {

        String expectedResult = "123";



        String result = sessionService.generateSessionId();

        assertEquals(expectedResult,result);

    }

    @Test
    public void testIsExpired_sessionIsNotExpired_returnBoolean() {



    }

    public SessionEntity createEntity(){
        SessionEntity entity = new SessionEntity();
        entity.setAuthorizationExpiredDate(LocalDate.now().plusDays(1));
        entity.setSessionId("123");
        entity.setUserId(1);
        return entity;
    }
}