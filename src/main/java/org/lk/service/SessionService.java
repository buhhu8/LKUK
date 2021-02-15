package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.model.domain.AuthorizationSessionEntity;
import org.lk.model.dto.SessionDto;
import org.lk.repository.jpa.JpaSessionRepository;
import org.lk.service.converter.Converter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SessionService {

    // @Qualifier("sessionConverter")
    private final Converter<AuthorizationSessionEntity, SessionDto> converter;
    private final JpaSessionRepository jpaSessionRepository;

    public String saveSessionId(Integer id) {
        SessionDto dto = new SessionDto();
        String sessionId = generateSessionId();
        dto.setUserId(id);
        dto.setSessionId(sessionId);
        dto.setAuthorizationExpiredDate(LocalDate.now().plusDays(1));
        jpaSessionRepository.save(converter.toEntity(dto));
        return sessionId;
    }

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public boolean isExpired(String sessionId) {
        return jpaSessionRepository.findBySessionId(sessionId)
                .map(session -> LocalDate.now().isEqual(session.getAuthorizationExpiredDate()) || LocalDate.now().isAfter(session.getAuthorizationExpiredDate()))
                .orElse(true);
    }

}