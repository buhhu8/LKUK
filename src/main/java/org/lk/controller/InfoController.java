package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.InfoDto;
import org.lk.service.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/userinfo")
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/{userId}")
    public InfoDto findUser(@PathVariable Integer userId) {
        return infoService.findUserById(userId);
    }

    @GetMapping("/flat/{flatNumber}")
    public InfoDto findUserByFlatNumber(@PathVariable String flatNumber) {
        return infoService.findUserByFlat(flatNumber);
    }

}
