package org.lk.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.lk.model.domain.InfoEntity;

@Getter
@Setter
public class AuthorizationDto {

    private Integer userId;
    private String login;
    private String password;
    private InfoEntity authInfo;

    private AuthorizationDto(){}

    public static AuthorizationDtoBuilder builder() {
        return new AuthorizationDto().new AuthorizationDtoBuilder();
    }

    public class AuthorizationDtoBuilder{
        public AuthorizationDtoBuilder login(String login){
            AuthorizationDto.this.login = login;
            return this;
        }
        public AuthorizationDtoBuilder password(String password){
            AuthorizationDto.this.password = password;
            return this;
        }
        public AuthorizationDtoBuilder authInfo(InfoEntity authInfo){
            AuthorizationDto.this.authInfo=authInfo;
            return this;
        }
        public AuthorizationDto build(){
            return AuthorizationDto.this;
        }
    }
}
