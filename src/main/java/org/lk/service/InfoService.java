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


    public InfoDto findUserById(Integer id) {
        Optional<InfoEntity> optional = jpaUserInfoRepository.findById(id);
        return convertToDto(optional);
    }

    @Transactional
    public InfoDto findUserByFlat(String flat) {
        Optional<InfoEntity> optional = jpaUserInfoRepository.findByFlat(flat);
        return convertToDto(optional);
    }

    public void addSomeInfo(InfoDto infoDto, String someInfo) {
        infoDto.setSomeInfo(someInfo);

    }

    public InfoDto convertToDto(Optional<InfoEntity> post) {
        InfoDto postDto = modelMapper.map(post.get(), InfoDto.class);
        return postDto;
    }

    public InfoEntity convertToEntity(Optional<InfoDto> post) {
        InfoEntity postEntity = modelMapper.map(post.get(), InfoEntity.class);
        return postEntity;
    }


}
