package org.lk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/profile")
public class ProfileController {

    @PostMapping
    public void fillUserProfile() {
        System.out.println("Fill user profile...");
    }

}

