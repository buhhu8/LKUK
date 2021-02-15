package org.lk.service.validation;

import org.lk.model.dto.RegistrationDto;

//TODO: ExceptionHandler, @ResponseStatus
public class RegistrationValidator implements Validator<RegistrationDto> {

    @Override
    public void validate(RegistrationDto obj) {
        requireNotBlank(obj.getFirstName());
        requireNotBlank(obj.getLastName());
    }

}
