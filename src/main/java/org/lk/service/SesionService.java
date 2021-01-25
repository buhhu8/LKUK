package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.model.domain.AuthorizationSessionEntity;
import org.lk.model.dto.SessionDto;
import org.lk.repository.jpa.JpaSessionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SesionService {

    private final JpaSessionRepository jpaSessionRepository;
    private final SessionDto sessionDto;
    private final ModelMapper modelMapper;

    public void SaveSessionId(Integer id) {
        jpaSessionRepository.save(convertToEntity(fillSessionDto(id)));
    }

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public Optional<SessionDto> fillSessionDto(Integer id) {
        sessionDto.setUserId(id);
        sessionDto.setSessionId(generateSessionId());
        sessionDto.setAuthorizationExpiredDate(LocalDate.now().plusDays(1));
        return Optional.of(sessionDto);

    }


    public SessionDto convertToDto(Optional<AuthorizationSessionEntity> post) {
        SessionDto postDto = modelMapper.map(post.get(), SessionDto.class);
        return postDto;
    }

    public AuthorizationSessionEntity convertToEntity(Optional<SessionDto> post) {
        AuthorizationSessionEntity postEntity = modelMapper.map(post.get(), AuthorizationSessionEntity.class);
        return postEntity;
    }

    public boolean isExpired(String sessionId) {
        return jpaSessionRepository.findBySessionId(sessionId)
                .map(session -> LocalDate.now().isEqual(session.getAuthorizationExpiredDate()) || LocalDate.now().isAfter(session.getAuthorizationExpiredDate()))
                .orElse(true);
    }

}
