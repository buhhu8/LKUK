package org.lk.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.lk.model.dto.RegistrationDto;
import org.lk.service.RegistrationService;
import org.lk.service.SessionService;
import org.lk.service.validation.RegistrationValidator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final SessionService sessionService;
    private final RegistrationValidator registrationValidator;

    @SneakyThrows
    @PostMapping("/registration") // TODO
    public void newUser(@RequestBody  RegistrationDto registrationDto) {
        registrationService.register(registrationDto);
    }

}
