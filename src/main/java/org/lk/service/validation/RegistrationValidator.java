package org.lk.service.validation;

import org.lk.model.dto.RegistrationDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

//TODO: ExceptionHandler, @ResponseStatus
@Component
public class RegistrationValidator implements Validator<RegistrationDto> {



    @Override
    public void validate(RegistrationDto obj) {

        requireNotBlank(obj.getFirstName());
        requireNotBlank(obj.getLastName());
    }

}
