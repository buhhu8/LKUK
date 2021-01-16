package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.UserAuthorizationRequest;
import org.lk.service.UserAuthorizationService;
import org.lk.service.UserSesionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authorization/session")
public class UserAuthorizationController {

    private UserAuthorizationService userAuthorizationService;
    private UserSesionService userSesionService;

    @PostMapping("/auth")
    public ResponseEntity<Object> authorizeUser(@RequestBody UserAuthorizationRequest request) {


        if (!userAuthorizationService.checkAuthorization(request.getId(),request.getPassword(),request.getLogin())) {

            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }
        userSesionService.saveSession(request.getId());
      //  String sessionId = sessionService.saveUserSession(request.getId());
        return ResponseEntity.ok()
//                .header("SESSION-ID", sessionId)
                .build(); // 200 with empty body
    }

}
