package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.AssetCategoryDto;
import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.dto.asset.AssetPartDto;
import com.knits.ammolite.mapper.asset.AssetCategoryMapper;
import com.knits.ammolite.mapper.asset.AssetCategoryMapperImpl;
import com.knits.ammolite.mocks.dto.asset.AssetCategoryDtoMock;
import com.knits.ammolite.mocks.dto.asset.AssetPartDtoMock;
import com.knits.ammolite.model.asset.AssetCategory;
import com.knits.ammolite.model.asset.AssetPart;
import com.knits.ammolite.repository.assets.AssetCategoryRepository;
import org.junit.jupiter.api.DisplayName;
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
class AssetCategoryServiceTest {

    @InjectMocks
    private AssetCategoryService service;

    @Mock
    private AssetCategoryRepository repository;

    @Spy
    private AssetCategoryMapper mapper = new AssetCategoryMapperImpl();
    @Captor
    private ArgumentCaptor<AssetCategory> captor;

    @Test
    @DisplayName("Save Asset Category")
    void save() {
        AssetCategoryDto inputAssetCategoryDto = AssetCategoryDtoMock.getAllFieldsDto(1l);
        when(repository.save(Mockito.any(AssetCategory.class))).thenAnswer(element ->   element.getArguments()[0]);
        when(repository.existsById(inputAssetCategoryDto.getId())).thenReturn(false);
        AssetCategoryDto savedAssetDto = service.save(inputAssetCategoryDto);
        verify(repository).save(captor.capture());
        AssetCategory toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputAssetCategoryDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputAssetCategoryDto).isEqualTo(savedAssetDto);
    }
}