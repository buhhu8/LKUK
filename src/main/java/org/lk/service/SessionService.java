package org.lk.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService {

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

}
