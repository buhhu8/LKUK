package org.lk.controller;

import org.lk.service.ApplicationUserService;
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

    private final ApplicationUserService service;

    boolean resultOfFindingLoginAndPassword;
    Map<String, String> loginAndPassword = new HashMap<>();

    @Autowired
    public AuthorizationController(ApplicationUserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public Greeting authentication(@RequestBody AuthorizaitonRequest request) {

        Greeting obj = new Greeting();

        resultOfFindingLoginAndPassword = loginAndPassword.entrySet().stream()
                .anyMatch(x -> x.getKey().equals(request.getLogin()) && x.getValue().equals(md5ApacheExample(request.getPassword())));

        obj.setPairs(resultOfFindingLoginAndPassword ? "User was found" : "User not found");
        return obj;
    }

    @PostMapping("/login/db")
    public Greeting authenticateUser(@RequestBody AuthorizaitonRequest request) {
        boolean result = service.authorizeUser(request.getLogin(), request.getPassword());

        Greeting obj = new Greeting();
        obj.setPairs(result  ? "User was found" : "User not found");
        return obj;
    }

    private String md5ApacheExample(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

    @PostConstruct
    public void init() {

        loginAndPassword.put("buhhu8", "d8578edf8458ce06fbc5bb76a58c5ca4");  //qwerty
        loginAndPassword.put("dmitry", "912ec803b2ce49e4a541068d495ab570");  //asdf
        loginAndPassword.put("anton", "fd2cc6c54239c40495a0d3a93b6380eb");  //zxcv
    }
}