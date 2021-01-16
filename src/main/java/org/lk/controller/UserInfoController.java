package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.domain.UserInfoEntity;
import org.lk.model.dto.UserInfoRequest;
import org.lk.service.UserInfoService;
import org.lk.service.UserSesionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authorization/session")
public class UserInfoController {
    private final UserInfoService userInfoService;



    @PostMapping("/userinfo")
    public Greeting findUser(@RequestBody UserInfoRequest request){

       UserInfoEntity user =  userInfoService.showUserInfo(request.getId());
       Greeting obj = new Greeting();
       obj.setPairs(user.toString());
       return obj;
    }
}
