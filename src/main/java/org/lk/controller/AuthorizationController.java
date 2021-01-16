package org.lk.controller;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.model.dto.ApplicationUser;
import org.lk.model.dto.AuthorizaitonRequest;
import org.lk.service.AuthorizationUserService;
import org.lk.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/authorization")
public class AuthorizationController {

    private final AuthorizationUserService service;
    private final SessionService sessionService;
    private ApplicationUserEntity result;

    @Autowired
    public AuthorizationController(AuthorizationUserService service, SessionService sessionService) {
        this.service = service;
        this.sessionService = sessionService;
    }

    @PostMapping("/login/bd1")
    public Greeting authorizateUser(@RequestBody AuthorizaitonRequest request) {
        Greeting obj = new Greeting();
//        result = service.authorizeUser(request.getId(), request.getPassword());
//        if (result != null) {
//            obj.setPairs(result.toString());
//        } else {
//            obj.setPairs("User not found");
//        }
        return obj;

    }

    @PostMapping // api/v1/authorization
    // ResponseEntity<ApplicationUserEntity> аналог ApplicationUserEntity
    public ResponseEntity<Object> authorizeUser(@RequestBody AuthorizaitonRequest request) {
        if (!service.authorizeUser(request.getId(), request.getPassword())) {
            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }

        String sessionId = sessionService.saveUserSession(request.getId());
        return ResponseEntity.ok()
                .header("SESSION-ID", sessionId)
                .build(); // 200 with empty body
    }

}