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

// controllers
//      .pages
//          @Controller - обычные
//      .rest
//          @RestController - это @Controller + @ResponseBody
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
        // registrationService.register(...);
        // authService.authorizeRegisteredUser(...);
        // return "menu";

        String codePassword = passwordEncoder.encode(infoDto.getPassword());

        // TODO: Remove Optional usage. It's redundant for this case because insertData method always returns non-null value
        InfoEntity infoEntity = infoService.convertToEntity(
                Optional.of(infoService.insertData(infoDto.getId(), infoDto.getFirstName(), infoDto.getLastName(), infoDto.getMiddleName(), infoDto.getFlat())));

        // TODO: Replace this to service layer
        jpaUserInfoRepository.save(infoEntity);

        AuthorizationEntity authorizationEntity = authorizationService
                .convertToEntity(Optional.of(authorizationService.insertData(infoEntity.getId(), infoDto.getLogin(), codePassword)));
        // TODO: Replace this to service layer
        jpaUserAuthorizationRepository.save(authorizationEntity);

        sesionService.saveSessionId(infoEntity.getId());

        return "menu";

    }

}
