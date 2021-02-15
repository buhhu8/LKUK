package org.lk.controller;

import org.lk.model.dto.AuthorizationDto;
import org.lk.service.AuthorizationService;
import org.lk.service.SessionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@RequestMapping("/api/v1/authorization/session")
public class AuthorizationController {

    private AuthorizationService authorizationService;

    private SessionService sessionService;

    public AuthorizationController(AuthorizationService authorizationService,  SessionService sessionService) {
        this.authorizationService = authorizationService;
        this.sessionService = sessionService;
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> authorizeUser(@RequestBody AuthorizationDto request) {


        if (!authorizationService.checkAuthorization(request.getLogin(), request.getPassword())) {

            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }

        String sessionId = sessionService.saveSessionId(authorizationService.returnId(request.getLogin()));
        System.out.println("SessionId:  " + sessionId);
        return ResponseEntity.ok()
                .header("SESSION-ID", sessionId)
                .build(); // 200 with empty body
    }


}
