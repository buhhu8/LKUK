package org.lk.controller;

import lombok.AllArgsConstructor;
import org.lk.model.dto.InfoDto;
import org.lk.service.InfoService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{userId}")
    public InfoDto updateUserById(@PathVariable Integer userId, @RequestBody InfoDto dto){
        return infoService.updateUserById(userId,dto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Integer userId){
        infoService.deleteUserById(userId);
    }

}
