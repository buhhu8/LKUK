package org.lk.service;


import lombok.AllArgsConstructor;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class InfoService {

    private final JpaUserInfoRepository jpaUserInfoRepository;
    private final ModelMapper modelMapper;


    public Optional<InfoEntity> findUserById(Integer id) {
        return jpaUserInfoRepository.findById(id);
    }

    @Transactional
    public Optional<InfoEntity> findUserByFlat(String flat) {
        return jpaUserInfoRepository.findByFlat(flat);

    }

    public void addSomeInfo(InfoDto infoDto, String someInfo) {
        infoDto.setSomeInfo(someInfo);

    }

    public InfoDto insertData(Integer id, String firstName, String lastName, String middleName, String flat) {
        InfoDto dto = new InfoDto();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setMiddleName(middleName);
        dto.setFlat(flat);
        return dto;
    }

    public InfoDto convertToDto(Optional<InfoEntity> post) {
        InfoDto postDto = modelMapper.map(post.get(), InfoDto.class);
        return postDto;
    }

    public InfoEntity convertToEntity(InfoDto post) {
        InfoEntity postEntity = modelMapper.map(post, InfoEntity.class);
        return postEntity;
    }



}
