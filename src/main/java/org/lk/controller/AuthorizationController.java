package org.lk.controller;

import org.lk.model.domain.ApplicationUserEntity;
import org.lk.service.AuthorizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userAuthorizationController")
@RequestMapping("/api/v1/authorization")
public class AuthorizationController {

    private final AuthorizationUserService service;
    private ApplicationUserEntity result;

    @Autowired
    public AuthorizationController(AuthorizationUserService service) {
        this.service = service;
    }

    @PostMapping("/login/bd1")
    public Greeting authorizateUser(@RequestBody AuthorizaitonRequest request) {
        Greeting obj = new Greeting();
        result = service.authorizeUser(request.getId(), request.getPassword());
        if (result != null) {
            obj.setPairs(result.toString());
        } else {
            obj.setPairs("User not found");
        }
        return obj;

    }
}