package org.lk.controller;

import lombok.RequiredArgsConstructor;
import org.lk.model.dto.InfoAndAuthDto;
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
    public void newUser(@RequestBody InfoAndAuthDto infoAndAuthDto){

        registrationService.saveInfo(infoAndAuthDto.getFirstName(),infoAndAuthDto.getLastName(),
                                         infoAndAuthDto.getMiddleName(), infoAndAuthDto.getFlat());

        registrationService.saveAuthInfo(infoAndAuthDto.getId(), infoAndAuthDto.getLogin(), infoAndAuthDto.getPassword());

        sessionService.saveSessionId(infoAndAuthDto.getId());
    }

}
