package org.lk.service;


import lombok.AllArgsConstructor;
import org.lk.model.domain.UserInfoEntity;
import org.lk.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoEntity showUserInfo(Integer id){

       return userInfoRepository.findById(id);
    }

}
