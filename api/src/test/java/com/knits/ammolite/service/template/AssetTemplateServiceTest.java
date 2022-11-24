package com.knits.ammolite.service.template;

import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.dto.template.AssetTemplateDto;
import com.knits.ammolite.mapper.template.AssetTemplateMapper;
import com.knits.ammolite.mapper.template.AssetTemplateMapperImpl;
import com.knits.ammolite.mocks.dto.template.AssetTemplateDtoMock;
import com.knits.ammolite.model.template.AssetTemplate;
import com.knits.ammolite.repository.template.AssetTemplateRepository;
import com.knits.ammolite.service.asset.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AssetTemplateServiceTest {

    @Mock
    private AssetTemplateRepository repository;

    @Spy
    private AssetTemplateMapper mapper=new AssetTemplateMapperImpl();

    @InjectMocks
    private AssetTemplateService assetTemplateService;

    @Mock
    private CategoryService categoryService;

    @Captor
    private ArgumentCaptor<AssetTemplate> captor;
    @Test
    void createAssetTemplate() {
        AssetTemplateDto inputAssetDto = AssetTemplateDtoMock.getAllFieldAssetTemplateDtoMock(1l);
        when(repository.save(Mockito.any(AssetTemplate.class))).thenAnswer(element ->   element.getArguments()[0]);
        when(repository.existsById(inputAssetDto.getId())).thenReturn(false);

        AssetDto savedAssetDto = assetTemplateService.createAssetTemplate(inputAssetDto);
        verify(repository).save(captor.capture());
        AssetTemplate toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputAssetDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputAssetDto).isEqualTo(savedAssetDto);
    }
}