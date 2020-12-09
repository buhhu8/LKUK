package org.lk.controller;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // @Controller
@RequestMapping("/greeting")
public class GreetingController {

    @PostMapping("/login")
    public Greeting authentication(@RequestBody GreetingRequest request) {
        Greeting obj = new Greeting();
        Boolean flag = false;
        Map<String, String> loginAndPassword = new HashMap<>();
        loginAndPassword.put("buhhu8", "d8578edf8458ce06fbc5bb76a58c5ca4");  //qwerty
        loginAndPassword.put("dmitry","912ec803b2ce49e4a541068d495ab570");  //asdf
        loginAndPassword.put("anton","fd2cc6c54239c40495a0d3a93b6380eb");  //zxcv
        for(Map.Entry<String, String> entry: loginAndPassword.entrySet()) {
            if(entry.getKey().equals(request.getLogin())){
                if (entry.getValue().equals(md5ApacheExample(request.getPassword()))){
                    obj.setPairs(request.getLogin() + " " + request.getPassword());
                    flag = true;
                }
                else if(flag == false){
                    obj.setPairs("User not found");
                }
            }
            else if (flag == false){
                obj.setPairs("User not found");
            }

        }
       return obj;
    }

    private static String md5ApacheExample(String text){
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

}