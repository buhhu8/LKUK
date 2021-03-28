package org.lk.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.lk.model.dto.RegistrationDto;
import org.lk.service.RegistrationService;
import org.lk.service.SessionService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final SessionService sessionService;

    @SneakyThrows
    @PostMapping("/registration") // TODO
    public void newUser(@RequestBody @Valid RegistrationDto registrationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
        } else {
            registrationService.register(registrationDto);
        }

    }

}
