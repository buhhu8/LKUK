package org.lk.Utils;

import org.lk.model.domain.UserInfoEntity;
import org.lk.model.dto.UserInfoDto;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMapping {

    public UserInfoDto mapToUserInfoDto(UserInfoEntity userInfoEntity){

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setFirstName(userInfoEntity.getFirstName());
        userInfoDto.setLastName(userInfoEntity.getLastName());
        userInfoDto.setMiddleName(userInfoEntity.getMiddleName());
        userInfoDto.setId(userInfoEntity.getId());
        userInfoDto.setFlat(userInfoEntity.getFlat());
        return userInfoDto;
    }

    public UserInfoEntity mapToUserInfoEntity(UserInfoDto userInfoDto){

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(userInfoDto.getId());
        userInfoEntity.setFirstName(userInfoDto.getFirstName());
        userInfoEntity.setLastName(userInfoDto.getLastName());
        userInfoEntity.setMiddleName(userInfoDto.getMiddleName());
        userInfoEntity.setFlat(userInfoDto.getFlat());
        return userInfoEntity;
    }

}
