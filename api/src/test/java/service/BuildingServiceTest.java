package service;

import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.mokcs.dto.BuildingDtoMock;
import com.knits.ammolite.repository.*;
import com.knits.ammolite.service.BuildingService;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.mapper.BuildingMapper;
import com.knits.ammolite.service.mapper.BuildingMapperImpl;
import com.knits.ammolite.service.mapper.LocationMapper;
import com.knits.ammolite.service.mapper.LocationMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BuildingServiceTest {

    @Mock
    private BuildingRepository buildingRepository;
    @Mock
    private LocationRepository locationRepository;
    @Mock
    private ContactRepository contactRepository;
    @Mock
    private SecurityContactRepository securityContactRepository;
    @Mock
    private ReceptionRepository receptionRepository;
    @Spy
    private final BuildingMapper buildingMapper = new BuildingMapperImpl();
    @Spy
    private final LocationMapper locationMapper = new LocationMapperImpl();
    @Captor
    private ArgumentCaptor<Building> buildingCaptor;
    @InjectMocks
    private BuildingService buildingService;

    @Test
    @DisplayName("Save Building Success")
    void saveSuccess() {

        BuildingDto toSaveDto = BuildingDtoMock.shallowBuildingDto(null);

        when(buildingRepository.save(Mockito.any(Building.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        BuildingDto savedDto= buildingService.create(toSaveDto);

        verify(buildingRepository).save(buildingCaptor.capture());
        Building toSaveEntity = buildingCaptor.getValue();

        verify(buildingMapper, times(1)).toEntity(toSaveDto);
        verify(buildingRepository, times(1)).save(toSaveEntity);
        verify(buildingMapper, times(1)).toDto(toSaveEntity);

        assertThat(toSaveDto).isEqualTo(savedDto);
    }

}
