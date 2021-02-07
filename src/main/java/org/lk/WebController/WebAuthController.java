package org.lk.WebController;

import lombok.AllArgsConstructor;
import org.lk.model.dto.AuthorizationDto;
import org.lk.model.dto.InfoAndAuthDto;
import org.lk.service.AuthorizationService;
import org.lk.service.InfoService;
import org.lk.service.SesionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class WebAuthController {

    AuthorizationService authorizationService;
    InfoService infoService;
    SesionService sesionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(Model model) {
        AuthorizationDto dto = new AuthorizationDto();
        model.addAttribute("dto", dto);
        return "index";

    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String checkAuth(Model model, @ModelAttribute AuthorizationDto dto) {

        if (authorizationService.checkAuthorization(dto.getLogin(), dto.getPassword())) {
            {
                sesionService.saveSessionId(1);
                return "menu";
            }

        }
        return "error";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(Model model) {

        InfoAndAuthDto dto = new InfoAndAuthDto();
        model.addAttribute("dto", dto);
        return "userRegistration";
    }

}