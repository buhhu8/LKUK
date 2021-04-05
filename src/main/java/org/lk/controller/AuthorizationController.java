package org.lk.controller;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.AuthorizationDto;
import org.lk.service.AuthorizationService;
import org.lk.service.SessionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authorization")
public class AuthorizationController {

    private final AuthorizationService authorizationService;
    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<Object> authorizeUser(@RequestBody AuthorizationDto dto) {
        if (!authorizationService.checkAuthorization(dto.getLogin(),dto.getPassword())) {
            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }
        String sessionId = sessionService.saveSessionId(authorizationService.returnId(dto.getLogin()));
        return ResponseEntity.ok()
                .header("SESSION-ID", sessionId)
                .header("USER-ID",String.valueOf(authorizationService.returnId(dto.getPassword())))
                .build(); // 200 with empty body
    }

}
