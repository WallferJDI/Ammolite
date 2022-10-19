/*
package com.knits.ammolite.service;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.repository.BusinessUnitRepository;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.mapper.BusinessUnitMapper;
import com.knits.ammolite.service.mapper.BusinessUnitMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BusinessUnitService.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BusinessUnitMapperImpl.class})
class BusinessUnitServiceTest {

    @MockBean
    private BusinessUnitMapper mapper = Mappers.getMapper(BusinessUnitMapperImpl.class);

    @Autowired
    private BusinessUnitMapper configurationMapper;

    @MockBean
    private BusinessUnitRepository repository;

    @InjectMocks
    private BusinessUnitService service = new BusinessUnitService();


    @Test
    public void TestIfBusinessUnitCreated(){
        when(configurationMapper.toEntity(any())).thenReturn(new BusinessUnit());
        when(repository.save(any())).thenReturn(new BusinessUnit());
        service.createBusinessUnit(mock(BusinessUnitDto.class));
        verify(configurationMapper).toEntity(any());
        verify(repository).save(any());
    }
}*/
