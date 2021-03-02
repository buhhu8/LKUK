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
@RequestMapping("/api/v1/authorization/session")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final SessionService sessionService;
    private final RegistrationValidator registrationValidator;


    @SneakyThrows
    @PostMapping("/registration")
    public void newUser(@RequestBody  RegistrationDto registrationDto) {

        registrationService.register(registrationDto);
        // registrationService.register(dto)
        // if success -> 200
        // if fail - > 400


        // RegistrationDto.builder()
        //        .login("")
        //        .build();

//        if (registrationService.register(registrationDto)) {
//            greeting.setPairs(registrationDto.getFirstName());
//            return greeting;
//        }
////        else {
////            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
////            greeting.setPairs(registrationDto.getFirstName());
////            return greeting;
////
////        }


    }

}
