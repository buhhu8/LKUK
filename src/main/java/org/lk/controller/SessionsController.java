package org.lk.controller;

import org.lk.interceptor.SessionIdInterceptor;
import org.lk.model.dto.AuthorizaitonRequest;
import org.lk.model.dto.SessionRequest;
import org.lk.repository.SessionRepository;
import org.lk.service.AuthorizationUserService;
import org.lk.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/authorization/session")
public class SessionsController {

    private final SessionService sessionService;
    private final SessionRepository sessionRepository;
    private final AuthorizationUserService authorizationUserService;


    @Autowired
    public SessionsController(SessionService sessionService, SessionRepository sessionRepository, AuthorizationUserService authorizationUserService) {
        this.sessionService = sessionService;
        this.sessionRepository = sessionRepository;
        this.authorizationUserService = authorizationUserService;
    }

    @PostMapping("/bd1")
    public void addCookies(@RequestBody AuthorizaitonRequest request, SessionRequest sessionRequest) {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis() + 100000000; // long now = new Date().getTime() + 1000000;

        long nextDay = TimeUnit.DAYS.toMillis(1);

        if (authorizationUserService.authorizeUser(request.getId(), request.getPassword())) {

            Date date = new Date(now); // expiredDate

            if (sessionRepository.AddCookiesIntoSessions(request.getId(), sessionService.generateSessionId(), date) != false) {

            } else {
                System.out.println("Not found");
            }
        }
    }

    @PostMapping("/bd2")
    public void checkCookie(@RequestBody AuthorizaitonRequest request) {
        String[] str = sessionRepository.checkCookieSession(request.getId()).toString().split(", ");
        StringBuilder builder = new StringBuilder(str[1]);
        System.out.println(builder.delete(0, 7));
       //SessionIdInterceptor sessionIdInterceptor = new SessionIdInterceptor();



    }

}


