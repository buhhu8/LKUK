package org.lk.controller;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.RegistrationDto;
import org.lk.model.dto.InfoDto;
import org.lk.service.RegistrationService;
import org.lk.service.SessionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authorization/session")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final SessionService sessionService;

    @PostMapping("/registration")
    public void newUser(@RequestBody RegistrationDto registrationDto){

        // registrationService.register(dto)
        // if success -> 200
        // if fail - > 400
        // TODO: authorization controller

        // RegistrationDto.builder()
        //        .login("")
        //        .build();

        InfoDto infoDto = registrationService.saveInfo(registrationDto);

        registrationService.saveAuthInfo(infoDto.getUserId(), registrationDto.getLogin(), registrationDto.getPassword());

    }

}
