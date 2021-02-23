package org.lk.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@Value
@Builder
@JsonDeserialize(builder = InfoDto.InfoDtoBuilder.class)
public class InfoDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String flat;
    private String someInfo;

    @JsonPOJOBuilder(withPrefix = "")
    public static class InfoDtoBuilder{}

}
