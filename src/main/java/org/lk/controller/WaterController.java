package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.WaterDto;
import org.lk.service.WaterService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class WaterController {

    WaterService waterService;

    @GetMapping("/{userId}/waters")
    public List<WaterDto> showAllWaterInfoById(@PathVariable Integer userId) {
        return waterService.findAllWaterById(userId);
    }

    @GetMapping("/{userId}/{date}")
    public WaterDto showWaterInfoByDate(@PathVariable Integer userId, @PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return waterService.findWaterByDate(userId, date);
    }

    @PostMapping("/{userId}/insert_water")
    public void insertIntoWater(@RequestBody WaterDto waterDto, @PathVariable Integer userId) {
        waterService.insertWater(userId,waterDto.getHot(), waterDto.getCold());
    }

}
