package service;

import com.knits.ammolite.model.location.Building;
import com.knits.ammolite.mocks.dto.BuildingDtoMock;
import com.knits.ammolite.mocks.dto.LocationDtoMock;
import com.knits.ammolite.mocks.model.BuildingMock;
import com.knits.ammolite.repository.building.BuildingRepository;
import com.knits.ammolite.repository.building.ContactRepository;
import com.knits.ammolite.repository.building.ReceptionRepository;
import com.knits.ammolite.repository.building.SecurityContactRepository;
import com.knits.ammolite.repository.location.LocationRepository;
import com.knits.ammolite.service.BuildingService;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.dto.location.LocationDto;
import com.knits.ammolite.service.mapper.building.BuildingMapper;
import com.knits.ammolite.service.mapper.building.BuildingMapperImpl;
import com.knits.ammolite.service.mapper.location.LocationMapper;
import com.knits.ammolite.service.mapper.location.LocationMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    @DisplayName("partial Update success")
    void partialUpdate (){

        Long entityIdToUpdate = 1L;
        String updateContactPhoneNumber = "99999999";
        Building foundEntity = BuildingMock.shallowBuilding(entityIdToUpdate);
        BuildingDto toUpdateDto =buildingMapper.toDto(foundEntity);
        toUpdateDto.getContact().setPhone(updateContactPhoneNumber);
        when(buildingRepository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));
        BuildingDto updatedDto =buildingService.partialUpdate(toUpdateDto);

        verify(buildingRepository).save(buildingCaptor.capture());
        Building toUpdateEntity = buildingCaptor.getValue();

        verify(buildingMapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(buildingRepository, times(1)).save(foundEntity);
        verify(buildingMapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);

    }

    @Test
    @DisplayName("Update Building success")
    void updateSuccess (){

        Long entityIdToUpdate = 1L;
        String updateContactPhoneNumber = "99999999";
        String updateSecurityPhoneNumber = "999999";
        String updateReceptionPhoneNumber = "999999";

        Building foundEntity = BuildingMock.shallowBuilding(entityIdToUpdate);
        BuildingDto toUpdateDto =buildingMapper.toDto(foundEntity);
        toUpdateDto.getContact().setPhone(updateContactPhoneNumber);
        toUpdateDto.getSecurity().setPhone(updateSecurityPhoneNumber);
        toUpdateDto.getReception().setPhone(updateReceptionPhoneNumber);
        when(buildingRepository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));
        BuildingDto updatedDto =buildingService.partialUpdate(toUpdateDto);

        verify(buildingRepository).save(buildingCaptor.capture());
        Building toUpdateEntity = buildingCaptor.getValue();

        verify(buildingMapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(buildingRepository, times(1)).save(foundEntity);
        verify(buildingMapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);

    }

    @Test
    @DisplayName("Delete Building success")
    void deleteSuccess (){

        Long entityIdToDelete = 1L;
        Building foundEntity = BuildingMock.shallowBuilding(entityIdToDelete);
        BuildingDto toDeleteDto =buildingMapper.toDto(foundEntity);
        when(buildingRepository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));
        buildingService.delete(entityIdToDelete);
        verify(buildingRepository,times(1)).deleteById(entityIdToDelete);

    }

    @Test
    @DisplayName("Find All Buildings By Location success")
    void findAllSuccess (){
        int expectedSize=10;
        LocationDto location = LocationDtoMock.shallowLocationDto(1l);
        List<Building> resultSet =BuildingMock.shallowListOfBuilding(expectedSize);
        when(buildingRepository.findAllByLocation_Title(location.getTitle())).thenReturn(resultSet);

        List<BuildingDto> resultsetDto = buildingService.findAllByLocation(location);
        verify(buildingMapper, times(expectedSize)).toDto(any(Building.class));
        assertThat(resultsetDto.size()).isEqualTo(expectedSize);
    }

    }

