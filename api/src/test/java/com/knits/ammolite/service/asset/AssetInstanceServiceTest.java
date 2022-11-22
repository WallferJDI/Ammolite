package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.AssetInstanceDto;
import com.knits.ammolite.mapper.asset.AssetInstanceMapper;
import com.knits.ammolite.mapper.asset.AssetInstanceMapperImpl;
import com.knits.ammolite.mocks.dto.asset.AssetInstanceDtoMock;
import com.knits.ammolite.model.asset.AssetInstance;
import com.knits.ammolite.repository.assets.AssetInstanceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AssetInstanceServiceTest {
    @InjectMocks
    private AssetInstanceService assetInstanceService;
    @Mock
    private AssetInstanceRepository repository;
    @Spy
    private AssetInstanceMapper mapper = new AssetInstanceMapperImpl();
    @Captor
    private ArgumentCaptor<AssetInstance> captor;
    @Mock
    private AssetService assetService;

    @Test
    @DisplayName("Save Asset Success")
    void save() {

        AssetInstanceDto inputAssetInstanceDto = AssetInstanceDtoMock.getAllFieldDto(1l);
        when(repository.save(Mockito.any(AssetInstance.class))).thenAnswer(e -> e.getArguments()[0]);

        AssetInstanceDto savedDto = assetInstanceService.save(inputAssetInstanceDto);
        verify(repository).save(captor.capture());
        AssetInstance toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputAssetInstanceDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputAssetInstanceDto).isEqualTo(savedDto);

    }
}