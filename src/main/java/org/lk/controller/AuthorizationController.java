package org.lk.controller;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    boolean resultOfFindingLoginAndPassword;
    Map<String, String> loginAndPassword = new HashMap<>();

    @PostMapping("/login")
    public Greeting authentication(@RequestBody AuthorizaitonRequest request) {
        Greeting obj = new Greeting();

        loginAndPassword.put("buhhu8", "d8578edf8458ce06fbc5bb76a58c5ca4");  //qwerty
        loginAndPassword.put("dmitry", "912ec803b2ce49e4a541068d495ab570");  //asdf
        loginAndPassword.put("anton", "fd2cc6c54239c40495a0d3a93b6380eb");  //zxcv

        resultOfFindingLoginAndPassword = loginAndPassword.entrySet().stream()
                .anyMatch(x -> x.getKey().equals(request.getLogin()) && x.getValue().equals(md5ApacheExample(request.getPassword())));

        obj.setPairs(resultOfFindingLoginAndPassword == true ? "User was found" : "User not found");
        return obj;
    }

    private static String md5ApacheExample(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }


}