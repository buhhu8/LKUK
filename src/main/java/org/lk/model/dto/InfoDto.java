package org.lk.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InfoDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String flat;

    private void InfoDto() {
    }

    public static InfoDtoBuilder builder() {
        return new InfoDto().new InfoDtoBuilder();
    }

    public class InfoDtoBuilder {
        public InfoDtoBuilder firstName(String firstName) {
            InfoDto.this.firstName = firstName;
            return this;
        }

        public InfoDtoBuilder lastName(String lastName) {
            InfoDto.this.lastName = lastName;
            return this;
        }

        public InfoDtoBuilder middleName(String middleName) {
            InfoDto.this.middleName = middleName;
            return this;
        }

        public InfoDtoBuilder flat(String flat) {
            InfoDto.this.flat = flat;
            return this;
        }

        public InfoDto build() {
            return InfoDto.this;
        }
    }

}
