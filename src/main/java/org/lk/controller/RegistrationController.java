package org.lk.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.lk.model.dto.RegistrationDto;
import org.lk.service.RegistrationService;
import org.lk.service.SessionService;
import org.springframework.http.ResponseEntity;
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

    @SneakyThrows
    @PostMapping("/registration")
    public ResponseEntity<Object> newUser(@RequestBody @Valid RegistrationDto registrationDto) {
        registrationService.register(registrationDto);
        return ResponseEntity.ok().build(); // returns 200 with empty body
    }

}
