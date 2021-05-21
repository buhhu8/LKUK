package org.lk.service;

import lombok.RequiredArgsConstructor;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final ModelMapper modelMapper;
    private final JpaUserInfoRepository jpaUserInfoRepository;

    public InfoDto findUserById(Integer id) {
        return jpaUserInfoRepository.findById(id)
                .map(entity -> modelMapper.map(entity, InfoDto.class))
                .orElseThrow(() -> new RuntimeException("No user with such ID: " + id));
    }

    public InfoDto findUserByFlat(String flat) {
        return jpaUserInfoRepository.findByFlat(flat)
                .map(entity -> modelMapper.map(entity, InfoDto.class))
                .orElseThrow(() -> new RuntimeException("Couldn't find user by such flat: " + flat));
    }

    public InfoDto updateUserById(Integer id, InfoDto dto){
        dto.setUserId(id);
        jpaUserInfoRepository.save(modelMapper.map(dto, InfoEntity.class));
        return dto;
    }

    public void deleteUserById(Integer id){
        jpaUserInfoRepository.deleteById(id);
    }

}
