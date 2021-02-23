package org.lk.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.RegistrationDto;
import org.lk.service.RegistrationService;
import org.lk.service.SessionService;
import org.lk.service.validation.RegistrationValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authorization/session")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final SessionService sessionService;
    private final RegistrationValidator registrationValidator;


    @SneakyThrows
    @PostMapping("/registration")
    public ResponseEntity<Object> newUser(@RequestBody RegistrationDto registrationDto){




        // registrationService.register(dto)
        // if success -> 200
        // if fail - > 400


        // RegistrationDto.builder()
        //        .login("")
        //        .build();

       if(registrationService.register(registrationDto)){
            return ResponseEntity.status(200).build();
        }
       else{

           return ResponseEntity.status(400).build();
       }


    }

}
