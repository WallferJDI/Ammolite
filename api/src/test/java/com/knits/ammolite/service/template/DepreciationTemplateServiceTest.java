package com.knits.ammolite.service.template;

import com.knits.ammolite.dto.template.DepreciationTemplateDto;
import com.knits.ammolite.mapper.template.DepreciationTemplateMapper;
import com.knits.ammolite.mapper.template.DepreciationTemplateMapperImpl;
import com.knits.ammolite.mocks.dto.template.DepreciationTemplateDtoMock;
import com.knits.ammolite.model.template.DepreciationTemplate;
import com.knits.ammolite.repository.template.DepreciationTemplateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DepreciationTemplateServiceTest {

    @InjectMocks
    private DepreciationTemplateService service;
    @Mock
    private DepreciationTemplateRepository repository;
    @Spy
    private DepreciationTemplateMapper mapper = new DepreciationTemplateMapperImpl();
    @Captor
    private ArgumentCaptor<DepreciationTemplate> captor;

    @Test
    void save() {
        DepreciationTemplateDto inputDto = DepreciationTemplateDtoMock.getAllFieldDto(1l);
        when(repository.save(Mockito.any(DepreciationTemplate.class))).thenAnswer(element ->   element.getArguments()[0]);
        when(repository.existsById(inputDto.getId())).thenReturn(false);

        DepreciationTemplateDto savedDto = service.save(inputDto);
        verify(repository).save(captor.capture());
        DepreciationTemplate toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputDto).isEqualTo(savedDto);
    }
}