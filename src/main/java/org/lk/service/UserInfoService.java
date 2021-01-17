package org.lk.service;


import lombok.AllArgsConstructor;
import org.lk.Utils.UserInfoMapping;
import org.lk.model.domain.UserInfoEntity;
import org.lk.model.dto.UserInfoDto;
import org.lk.repository.UserInfoRepository;
import org.lk.repository.jpa.JpaUserAuthorizationSessionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserInfoService {

    private final JpaUserAuthorizationSessionRepository jpaUserAuthorizationSessionRepository;
    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapping userInfoMapping;
    private final ModelMapper modelMapper;

    public UserInfoEntity showUserInfo(Integer id){
       return userInfoRepository.findById(id);
    }

    public UserInfoDto findUserInfo(Integer id){
        Optional<UserInfoEntity> optional = jpaUserAuthorizationSessionRepository.findById(id);
        // userInfoRepository.findById(id)
        return optional
                .map(userInfoMapping::mapToUserInfoDto)
                // .map(user -> userInfoMapping.mapToUserInfoDto(user))
                .orElse(null);
        //return modelMapper.map(userInfoRepository.findById(id), UserInfoDto.class);
    }

    @Transactional
    public UserInfoDto findUserByFlat(String flat) {
        Optional<UserInfoEntity> optional = jpaUserAuthorizationSessionRepository.findByFlat(flat);
        // userInfoRepository.findById(id)
        return optional
                .map(userInfoMapping::mapToUserInfoDto)
                // .map(user -> userInfoMapping.mapToUserInfoDto(user))
                .orElse(null);
    }

    public void addSomeInfo (UserInfoDto userInfoDto, String someInfo){

        userInfoDto.setSomeInfo(someInfo);

    }


}
