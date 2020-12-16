package org.lk.controller;

import org.lk.service.ApplicationUserService;
import org.lk.service.AuthorizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController("userAuthorizationController")
@RequestMapping("/authorization")
public class AuthorizationController {

  //  private final ApplicationUserService service;
    private final AuthorizationUserService service;


//    @Autowired
//    public AuthorizationController(ApplicationUserService service) {
//        this.service = service;
//    }

    @Autowired
    public AuthorizationController(AuthorizationUserService service) {this.service = service;}



//    @PostMapping("/login/db")
//    public Greeting authenticateUser(@RequestBody AuthorizaitonRequest request) {
//
//        boolean result = service.authorizeUser(request.getLogin(), request.getPassword());
//
//        Greeting obj = new Greeting();
//        obj.setPairs(result  ? "User was found" : "User not found");
//        return obj;
//    }

    @PostMapping("/login/bd1")
    public Greeting authorizateUser(@RequestBody AuthorizaitonRequest request) {

        boolean result = service.authorizeUser(request.getLogin(),request.getPassword());

        Greeting obj = new Greeting();
        obj.setPairs(result ? "User was found" : "User not found");
        return obj;

    }


}