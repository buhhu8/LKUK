package org.lk.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lk.model.domain.InfoEntity;
import org.lk.model.domain.WaterEntity;
import org.lk.model.dto.WaterDto;
import org.lk.repository.jpa.JpaUserInfoRepository;
import org.lk.repository.jpa.JpaWaterRepository;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class WaterServiceTest {

    @Mock
    private JpaWaterRepository jpaWaterRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private JpaUserInfoRepository userInfoRepository;

    @InjectMocks
    private WaterService waterService;


    @Test
    public void testFindWaterByDate_waterExists_returnMappedDto() {

        WaterEntity entity = createEntity();
        WaterDto expectedResult = createDto();
        when(jpaWaterRepository.findByUserIdAndDateWater(1,LocalDate.of(2021,04,06)))
                .thenReturn(Optional.of(entity));
        when(modelMapper.map(entity, WaterDto.class))
                .thenReturn(expectedResult);

        WaterDto result = waterService.findWaterByDate(1,LocalDate.of(2021,04,06));

        assertEquals(expectedResult,result);

    }

    @Test
    public void testFindWaterByDate_waterDoesntExist_returnException(){
        when(jpaWaterRepository.findByUserIdAndDateWater(1,LocalDate.of(2021,04,06)))
                .thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, ()-> waterService.findWaterByDate(1,LocalDate.of(2021,04,06)) );
    }

    @Test
    public void testFindAllWaterById_waterExists_returnMappedDto() {

        WaterDto dto = createDto();
        WaterEntity entity = createEntity();
        List<WaterDto> expectedResult = new ArrayList<WaterDto>();
        List<WaterEntity> entityList = new ArrayList<WaterEntity>();
        expectedResult.add(dto);
        entityList.add(entity);

        when(jpaWaterRepository.findAllById(1))
                .thenReturn(entityList);
        when(modelMapper.map(entity, WaterDto.class))
                .thenReturn(dto);

        List<WaterDto> result = waterService.findAllWaterById(1);

        assertEquals(expectedResult,result);

    }

    @Test
    public void testFindAllWaterById_waterDoesNotExist_returnNullList(){
        List<WaterEntity> expectedResult = new ArrayList<>();
        when(jpaWaterRepository.findAllById(1))
                .thenReturn(expectedResult);
        List<WaterDto> result = waterService.findAllWaterById(1);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testInsertWater_validData_saveEntity() {

        WaterEntity entity = createEntity();
        //when(jpaWaterRepository.save(entity)).thenReturn(entity);
        Mockito.when(userInfoRepository.getOne(entity.getUserInfo().getInfoUserId()))
                .thenReturn(entity.getUserInfo());

        waterService.insertWater(entity.getUserInfo().getInfoUserId(), entity.getHot(),entity.getCold());

        ArgumentCaptor<WaterEntity> captor = ArgumentCaptor.forClass(WaterEntity.class);
        Mockito.verify(jpaWaterRepository).save(captor.capture()); // ArgumentMatchers.any();

        WaterEntity saveEntity = captor.getValue();
        assertEquals(entity.getUserInfo().getInfoUserId(), saveEntity.getUserInfo().getInfoUserId());
    }

    public WaterDto createDto(){
        WaterDto dto = new WaterDto();
        dto.setCold("12");
        dto.setHot("23");
        dto.setDateWater(LocalDate.of(2021,04,06));
        dto.setUserId(1);
        return dto;
    }

    public WaterEntity createEntity(){
        WaterEntity entity = new WaterEntity();
        entity.setCold("12");
        entity.setHot("23");
        entity.setDateWater(LocalDate.of(2021,04,06));
        entity.setUserInfo(createInfoEntity());
        return entity;
    }

    public InfoEntity createInfoEntity(){
        InfoEntity infoEntity = new InfoEntity();
        infoEntity.setFirstName("Den");
        infoEntity.setLastName("sd");
        infoEntity.setInfoUserId(1);
        return infoEntity;

    }

}