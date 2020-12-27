package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.ApplicationUser;
import org.lk.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public String saveUserSession(Integer userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionRepository.saveUserSession(userId, sessionId);

        return sessionId;
    }

    public boolean isExpired(String sessionId) {
        return sessionRepository.findBySessionId(sessionId)
                .map(session -> LocalDate.now().isEqual(session.getDateexperience()) || LocalDate.now().isAfter(session.getDateexperience()))
                .orElse(true);
    }

}
