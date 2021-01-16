package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.repository.UserAuthorizationSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserSesionService {

    private final UserAuthorizationSessionRepository userAuthorizationSessionRepository;

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public void saveSession(Integer id){
       LocalDate expiredDate = LocalDate.now().plusDays(1);
       String sessionId = generateSessionId();
       userAuthorizationSessionRepository.saveSessionId(id,sessionId,expiredDate);

    }
    public boolean isExpired(String sessionId) {
        return userAuthorizationSessionRepository.findBySessionId(sessionId)
                .map(session -> LocalDate.now().isEqual(session.getAuthorizationExpiredDate()) || LocalDate.now().isAfter(session.getAuthorizationExpiredDate()))
                .orElse(true);
    }

}
