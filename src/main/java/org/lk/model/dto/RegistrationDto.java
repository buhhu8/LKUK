package org.lk.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value // make class immutable
@Builder
@JsonDeserialize(builder = RegistrationDto.RegistrationDtoBuilder.class)
public class RegistrationDto {

    @NotEmpty(message = "Login shouldn't be empty")
    String login;
    @NotEmpty(message = "Password shouldn't be empty")
    @Size(min = 5, message = "Password should be more than 5 characters")
    String password;
    @NotEmpty(message = "FirstName shouldn't be empty")
    String firstName;
    String lastName;
    String middleName;
    String flat;
    String someInfo;

    @JsonPOJOBuilder(withPrefix = "")
    // withLogin()          -> login();
    // withPassword()       -> password();
    public static class RegistrationDtoBuilder {

    }

}
