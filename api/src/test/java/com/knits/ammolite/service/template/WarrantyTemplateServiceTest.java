package com.knits.ammolite.service.template;


import com.knits.ammolite.dto.template.WarrantyTemplateDto;
import com.knits.ammolite.mapper.template.WarrantyTemplateMapper;
import com.knits.ammolite.mapper.template.WarrantyTemplateMapperImpl;
import com.knits.ammolite.model.template.WarrantyTemplate;
import com.knits.ammolite.repository.template.WarrantyTemplateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class WarrantyTemplateServiceTest {

    @Spy
    private WarrantyTemplateMapper mapper = new WarrantyTemplateMapperImpl();
    @Mock
    private WarrantyTemplateRepository repository;
    @InjectMocks
    private WarrantyTemplateService service;
    @Captor
    private ArgumentCaptor<WarrantyTemplate> captor;

    @Test
    void save() {
        WarrantyTemplateDto inputWarrantyDto = WarrantyTemplateDto.builder()
                .id(1l).description("test")
                .fullCoverage(true)
                .maxCoverage(BigDecimal.valueOf(12000))
                .build();
        when(repository.save(Mockito.any(WarrantyTemplate.class))).thenAnswer(element ->   element.getArguments()[0]);
        when(repository.existsById(inputWarrantyDto.getId())).thenReturn(false);

        WarrantyTemplateDto savedWarrantyDto = service.save(inputWarrantyDto);
        verify(repository).save(captor.capture());
        WarrantyTemplate toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputWarrantyDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputWarrantyDto).isEqualTo(savedWarrantyDto);
    }
}