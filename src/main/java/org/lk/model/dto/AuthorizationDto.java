package org.lk.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.lk.model.domain.InfoEntity;

@Value
@Builder
@JsonDeserialize(builder = AuthorizationDto.AuthorizationDtoBuilder.class)
public class AuthorizationDto {

    private Integer userId;
    private String login;
    private String password;
    private InfoEntity authInfo;

    @JsonPOJOBuilder(withPrefix = "")
    public static class AuthorizationDtoBuilder{}

}
