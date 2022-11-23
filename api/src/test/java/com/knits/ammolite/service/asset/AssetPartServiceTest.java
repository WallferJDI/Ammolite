package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.dto.asset.AssetPartDto;
import com.knits.ammolite.mapper.asset.AssetPartMapper;
import com.knits.ammolite.mapper.asset.AssetPartMapperImpl;
import com.knits.ammolite.mocks.dto.asset.AssetPartDtoMock;
import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.model.asset.AssetPart;
import com.knits.ammolite.repository.assets.AssetPartRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AssetPartServiceTest {
    @InjectMocks
    private AssetPartService assetPartService;
    @Mock
    private AssetPartRepository repository;
    @Spy
    private AssetPartMapper mapper = new AssetPartMapperImpl();
    @Captor
    private ArgumentCaptor<AssetPart> captor;
    @Mock
    private AssetService assetService;

    @Test
    @DisplayName("Save Asset Part")
    void save() {
        AssetPartDto inputAssetPartDto = AssetPartDtoMock.getAllFieldsDtoMock(1l);
        System.out.println("INPUT "+ inputAssetPartDto);
        when(repository.save(Mockito.any(AssetPart.class))).thenAnswer(element ->   element.getArguments()[0]);
        when(assetService.save(Mockito.any(AssetDto.class))).thenAnswer(e -> e.getArguments()[0]);
        AssetPartDto savedAssetDto = assetPartService.save(inputAssetPartDto);
        verify(repository).save(captor.capture());
        AssetPart toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputAssetPartDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputAssetPartDto).isEqualTo(savedAssetDto);

    }
}