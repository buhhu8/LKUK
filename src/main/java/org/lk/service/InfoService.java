package org.lk.service;


import lombok.AllArgsConstructor;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class InfoService {

    private final JpaUserInfoRepository jpaUserInfoRepository;

    public InfoEntity findUserById(Integer id) {
        return jpaUserInfoRepository.findById(id).get();
    }

    @Transactional
    public InfoEntity findUserByFlat(String flat) {
        return jpaUserInfoRepository.findByFlat(flat).get();

    }

    public void addSomeInfo(InfoDto infoDto, String someInfo) {
        infoDto.setSomeInfo(someInfo);

    }

    public InfoDto insertData(String firstName, String lastName, String middleName, String flat) {
        InfoDto dto = new InfoDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setMiddleName(middleName);
        dto.setFlat(flat);
        return dto;
    }

}
