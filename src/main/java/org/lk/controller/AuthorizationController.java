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

    @GetMapping("/{login}/{password}")
    public ResponseEntity<Object> authorizeUser(@PathVariable String login,@PathVariable String password) {
        if (!authorizationService.checkAuthorization(login,password)) {
            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }
        String sessionId = sessionService.saveSessionId(authorizationService.returnId(login));
        return ResponseEntity.ok()
                .header("SESSION-ID", sessionId)
                .header("USER-ID",String.valueOf(authorizationService.returnId(login)))
                .build(); // 200 with empty body
    }

}
