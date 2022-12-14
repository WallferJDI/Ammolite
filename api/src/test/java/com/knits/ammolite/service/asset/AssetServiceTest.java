package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.mapper.asset.AssetMapper;
import com.knits.ammolite.mapper.asset.AssetMapperImpl;
import com.knits.ammolite.mocks.dto.asset.AssetDtoMock;
import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.repository.assets.AssetRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AssetServiceTest {

    @InjectMocks
    private AssetService assetService;
    @Spy
    private AssetMapper mapper = new AssetMapperImpl();
    @Mock
    private AssetRepository repository;
    @Captor
    private ArgumentCaptor<Asset> captor;
    @Mock
    private CategoryService categoryService;
    @Test
    @DisplayName("Save not existing before Asset")
    void save() {
        AssetDto inputAssetDto = AssetDtoMock.getAllFieldAssetDtoMock(1l);
        when(repository.save(Mockito.any(Asset.class))).thenAnswer(element ->   element.getArguments()[0]);
        when(repository.existsById(inputAssetDto.getId())).thenReturn(false);

        AssetDto savedAssetDto = assetService.save(inputAssetDto);
        verify(repository).save(captor.capture());
        Asset toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputAssetDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputAssetDto).isEqualTo(savedAssetDto);

    }

    @DisplayName("Save existing Asset Success")
    @Disabled
    @Test
    void saveExistingAsset() {
        AssetDto inputAssetDto = AssetDtoMock.getAllFieldAssetDtoMock(1l);
        when(repository.existsById(inputAssetDto.getId())).thenReturn(true);
        when(repository.findById(inputAssetDto.getId())).thenAnswer(element ->   element.getArguments()[0]);

        AssetDto savedAssetDto = assetService.save(inputAssetDto);
        verify(repository).save(captor.capture());
        Asset toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputAssetDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputAssetDto).isEqualTo(savedAssetDto);

    }

    @Test
    @DisplayName("Partial Update")
    void partialUpdate() {
        Long entityToUpdateId = 1l;
        String updatedName = "new name";

        Asset inputAsset = mapper.toEntity(AssetDtoMock.getAllFieldAssetDtoMock(entityToUpdateId));
        AssetDto updated = mapper.toDto(inputAsset);
        updated.setName(updatedName);
        System.out.println(updated);
        when(repository.findById(entityToUpdateId)).thenReturn(Optional.of(inputAsset));
        when(repository.save(Mockito.any(Asset.class))).thenAnswer(e -> e.getArguments()[0]);
        AssetDto output = assetService.partialUpdate(updated);

        verify(repository).save(captor.capture());
        Asset assetCaptor = captor.getValue();

        verify(mapper,times(1)).partialUpdate(assetCaptor,updated);
        verify(repository,times(1)).save(inputAsset);
        assertThat(updated).isEqualTo(output);


    }
}