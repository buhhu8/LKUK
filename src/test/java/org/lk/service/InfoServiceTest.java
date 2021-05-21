package org.lk.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lk.model.domain.InfoEntity;
import org.lk.model.dto.InfoDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class InfoServiceTest {

    @Mock
    private ModelMapper modelMapper;
    @Mock
    private JpaUserInfoRepository jpaUserInfoRepository;

    @InjectMocks // new InfoService(mockModelMapper, mockJpaUserInfoRepository)
    private InfoService infoService;

    @Test
    public void testFindUserById_userExists_returnMappedDto() {
        // given
        InfoDto expectedResult = createInfoDto(10);
        InfoEntity entity = createInfoEntity(10);

        when(jpaUserInfoRepository.findById(10))
                .thenReturn(Optional.of(entity));
        when(modelMapper.map(entity, InfoDto.class))
                .thenReturn(expectedResult);

        // when
        InfoDto result = infoService.findUserById(10);

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindUserById_userDoesNotExist_throwException() {
        // given
        when(jpaUserInfoRepository.findById(10))
                .thenReturn(Optional.empty());

        // where
        assertThrows(RuntimeException.class, () -> infoService.findUserById(10));
    }

    @Test
    public void testUpdateUserById_validData_saveEntity() {
        // given
        InfoDto infoDto = new InfoDto();
        InfoEntity entity = new InfoEntity();
        Integer userId = 15;

        when(modelMapper.map(infoDto, InfoEntity.class))
                .thenReturn(entity);

        // when
        InfoDto result = infoService.updateUserById(userId, infoDto);

        // then
        assertEquals(userId, result.getUserId());
        verify(modelMapper).map(infoDto, InfoEntity.class);
        verify(jpaUserInfoRepository).save(entity);
    }

    @Test
    public void testFindUserByFlat_flatExists_returnMappedDto(){
        //given
        InfoDto expectedResult = createInfoDto(1);
        InfoEntity entity = createInfoEntity(1);
        when(jpaUserInfoRepository.findByFlat("234"))
                .thenReturn(Optional.of(entity));
        when(modelMapper.map(entity,InfoDto.class))
                .thenReturn(expectedResult);

        //when
        InfoDto result = infoService.findUserByFlat("234");
        //then
        assertEquals(expectedResult,result);
    }

    private InfoEntity createInfoEntity(Integer userId) {
        InfoEntity entity = new InfoEntity();
        entity.setInfoUserId(userId);
        entity.setFirstName("user_name");
        entity.setFlat("234");
        return entity;
    }

    private InfoDto createInfoDto(Integer userId) {
        InfoDto dto = new InfoDto();
        dto.setUserId(userId);
        dto.setFirstName("user_name");
        dto.setFlat("234");

        return dto;
    }
}