package org.lk.WebController;

import lombok.AllArgsConstructor;
import org.lk.model.dto.InfoDto;
import org.lk.service.AuthorizationService;
import org.lk.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebInfoController {
    private final InfoService infoService;
    private final AuthorizationService authorizationService;

    @GetMapping("/info")
    public String showInfo(Model model) {

        InfoDto info = infoService.convertToDto(infoService.findUserById(1));
        model.addAttribute("someInfo", info);
        model.addAttribute("someInfo", info);

        return "info";
    }

}