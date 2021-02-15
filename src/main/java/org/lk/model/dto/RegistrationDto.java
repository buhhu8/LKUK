package org.lk.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value // make class immutable
@Builder
@JsonDeserialize(builder = RegistrationDto.RegistrationDtoBuilder.class)
public class RegistrationDto {

    // TCP - telescoping constructor parameters - use Builder pattern
    // private final
    String login;
    String password;
    String firstName;
    String lastName;
    String middleName;
    String flat;
    String someInfo;
    String sessionId;
    LocalDate authorizationExpiredDate;

    @JsonPOJOBuilder(withPrefix = "")
    // withLogin()          -> login();
    // withPassword()       -> password();
    public static class RegistrationDtoBuilder {

    }

}
