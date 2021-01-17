package org.lk.service;


import lombok.AllArgsConstructor;
import org.lk.Utils.UserInfoMapping;
import org.lk.model.domain.UserInfoEntity;
import org.lk.model.dto.UserInfoDto;
import org.lk.repository.UserInfoRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapping userInfoMapping;


    public UserInfoEntity showUserInfo(Integer id){

       return userInfoRepository.findById(id);
    }

    public UserInfoDto findUserInfo(Integer id){

        return userInfoMapping.mapToUserInfoDto(userInfoRepository.findById(id));
    }

    public void addSomeInfo (UserInfoDto userInfoDto, String someInfo){

        userInfoDto.setSomeInfo(someInfo);

    }


}
