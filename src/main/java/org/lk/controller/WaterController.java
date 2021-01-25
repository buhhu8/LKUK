package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.WaterDto;
import org.lk.service.WaterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/session")
public class WaterController {

    WaterService waterService;

    @PostMapping("/waterinfo")
    public Greeting showWaterInfoById(@RequestBody WaterDto waterDto) {
        Greeting greeting = new Greeting();
        WaterDto infoWater = waterService.finById(waterDto.getId());
        greeting.setPairs("Id: " + infoWater.getId() + " Hot:" + infoWater.getHot() + " Cold:" + infoWater.getCold() + " Date:" + infoWater.getDateWater());
        return greeting;
    }

}
