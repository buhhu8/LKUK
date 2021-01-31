package org.lk.WebController;

import lombok.AllArgsConstructor;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoAndAuthDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.service.AuthorizationService;
import org.lk.service.InfoService;
import org.lk.service.SesionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class WebRegistrationController {

    PasswordEncoder passwordEncoder;
    InfoService infoService;
    AuthorizationService authorizationService;
    SesionService sesionService;
    JpaUserInfoRepository jpaUserInfoRepository;
    JpaUserAuthorizationRepository jpaUserAuthorizationRepository;

    @RequestMapping(value = "/registrationForm", method = RequestMethod.POST)
    public String userRegistration(Model model, @ModelAttribute InfoAndAuthDto infoDto) {
        String codePassword = passwordEncoder.encode(infoDto.getPassword());
        InfoEntity infoEntity = infoService.convertToEntity(Optional.of(infoService.insertData(infoDto.getId(), infoDto.getFirstName(), infoDto.getLastName(), infoDto.getMiddleName(), infoDto.getFlat())));
        jpaUserInfoRepository.save(infoEntity);
        AuthorizationEntity authorizationEntity = authorizationService.convertToEntity(Optional.of(authorizationService.insertData(infoDto.getId(), infoDto.getLogin(), codePassword)));
        jpaUserAuthorizationRepository.save(authorizationEntity);
        sesionService.SaveSessionId(infoDto.getId());
        return "menu";

    }

}
