package org.lk.stressfull.test;

import org.lk.model.dto.AuthorizationDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class AuthorizationControllerStressfulTest {

    @GetMapping
    public void loadAuthorization() {
        RestTemplate restTemplate = new RestTemplate();


        // POST http://localhost:5696/api/v1/authorization/session/auth
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 40; i++) {
            AuthorizationDto dto = AuthorizationDto.builder()
                .userId(i)
                    .login("admin")
                    .password("admin")
                    .build();

            executorService.submit(() -> {

                System.out.println("Send request to authorization " + dto.getUserId());
                restTemplate.postForEntity("http://localhost:5696/api/v1/authorization/session/auth", dto, Object.class);
            });
        }
    }

}
