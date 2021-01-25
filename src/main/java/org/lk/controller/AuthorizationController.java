package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.AuthorizationDto;
import org.lk.service.AuthorizationService;
import org.lk.service.SesionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authorization/session")
public class AuthorizationController {

    private AuthorizationService authorizationService;
    private SesionService sesionService;


    @PostMapping("/auth")
    public ResponseEntity<Object> authorizeUser(@RequestBody AuthorizationDto request) {


        if (!authorizationService.checkAuthorization(request.getId(), request.getLogin(), request.getPassword())) {

            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }

        sesionService.SaveSessionId(request.getId());
        return ResponseEntity.ok()
//                .header("SESSION-ID", sessionId)
                .build(); // 200 with empty body
    }


}
