package org.lk.service;

import org.lk.controller.AuthorizaitonRequest;
import org.lk.model.domain.ApplicationUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class SessionService {



    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

}
