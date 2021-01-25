package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.InfoDto;
import org.lk.service.InfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/session")
public class InfoController {
    private final InfoService infoService;


    @PostMapping("/userinfo")
    public Greeting findUser(@RequestBody InfoDto request) {

        InfoDto user = infoService.findUserById(request.getId());
        infoService.addSomeInfo(user, "Тут живет хороший человек");
        Greeting obj = new Greeting();
        obj.setPairs(user.toString());
        return obj;
    }

    @PostMapping("/userinfo/find")
    public Greeting findUserBySmth(@RequestBody InfoDto request) {

        InfoDto user = infoService.findUserByFlat(request.getFlat());
        infoService.addSomeInfo(user, "Тут живет хороший человек");
        Greeting obj = new Greeting();
        obj.setPairs(user.toString());
        return obj;
    }

}
