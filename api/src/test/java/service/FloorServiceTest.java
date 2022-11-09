package service;

import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.model.location.Building;
import com.knits.ammolite.model.location.RealEstateType;
import com.knits.ammolite.mocks.dto.FloorDtoMock;
import com.knits.ammolite.mocks.model.FloorMock;
import com.knits.ammolite.repository.FloorRepository;
import com.knits.ammolite.repository.building.BuildingRepository;
import com.knits.ammolite.service.FloorService;
import com.knits.ammolite.service.dto.FloorDto;
import com.knits.ammolite.service.mapper.FloorMapper;
import com.knits.ammolite.service.mapper.FloorMapperImpl;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FloorServiceTest {

    @Mock
    private FloorRepository floorRepository;

    @Mock
    private BuildingRepository buildingRepository;
    @Spy
    private FloorMapper floorMapper = new FloorMapperImpl();

    @Spy
    private BuildingMapper buildingMapper = new BuildingMapperImpl();
    @Spy
    private LocationMapper locationMapper = new LocationMapperImpl();


    @InjectMocks
    private FloorService floorService;

    @Captor
    private ArgumentCaptor<Floor> floorCaptor;


    @Test
    @DisplayName("Save Floor Success")
    void saveSuccess() {

        FloorDto toSaveDto = FloorDtoMock.shallowFloorDto(null);
        Building building = buildingMapper.toEntity(toSaveDto.getBuilding());
        buildingRepository.save(building);
        when(buildingRepository.findById(toSaveDto.getBuilding().getId())).thenReturn(Optional.of(building));
        when(floorRepository.save(any(Floor.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        FloorDto savedDto = floorService.create(toSaveDto);
        verify(floorRepository).save(floorCaptor.capture());
        Floor toSaveEntity = floorCaptor.getValue();

        verify(floorMapper, times(1)).toEntity(toSaveDto);
        verify(floorRepository, times(1)).save(toSaveEntity);
        verify(floorMapper, times(1)).toDto(toSaveEntity);

        assertThat(toSaveDto).isEqualTo(savedDto);
    }

    @Test
    @DisplayName("partial Update success")
    void partialUpdate (){

        Long entityIdToUpdate = 1L;
        String updateRealEstate = "WAREHOUSE";
        Floor foundEntity = FloorMock.shallowFloor(entityIdToUpdate);
        FloorDto toUpdateDto =floorMapper.toDto(foundEntity);
        toUpdateDto.setRealEstate(updateRealEstate);
        when(floorRepository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));
        FloorDto updatedDto =floorService.partialUpdate(toUpdateDto);

        verify(floorRepository).save(floorCaptor.capture());
        Floor toUpdateEntity = floorCaptor.getValue();

        verify(floorMapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(floorRepository, times(1)).save(foundEntity);
        verify(floorMapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);

    }

    @Test
    @DisplayName("Update Floor success")
    void updateSuccess (){

        Long entityIdToUpdate = 1L;
        String updateRealEstate = "WAREHOUSE";
        String updateFloorNumber = "2";

        Floor foundEntity = FloorMock.shallowFloor(entityIdToUpdate);
        FloorDto toUpdateDto =floorMapper.toDto(foundEntity);
        toUpdateDto.setRealEstate(updateRealEstate);
        toUpdateDto.setFloorNumber(updateFloorNumber);
        when(floorRepository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));
        FloorDto updatedDto =floorService.partialUpdate(toUpdateDto);

        verify(floorRepository).save(floorCaptor.capture());
        Floor toUpdateEntity = floorCaptor.getValue();

        verify(floorMapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(floorRepository, times(1)).save(foundEntity);
        verify(floorMapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);
    }

    @Test
    @DisplayName("Delete Floor success")
    void deleteSuccess (){

        Long entityIdToDelete = 1L;
        Floor foundEntity = FloorMock.shallowFloor(entityIdToDelete);
        FloorDto toDeleteDto =floorMapper.toDto(foundEntity);
        when(floorRepository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));
        floorService.delete(entityIdToDelete);
        verify(floorRepository,times(1)).deleteById(entityIdToDelete);

    }

    @Test
    @DisplayName("Find All Floor By Real Estate success")
    void findAllSuccess (){
        int expectedSize=10;
        FloorDto floorDto = FloorDtoMock.shallowFloorDto(1l);
        List<Floor> resultSet = FloorMock.shallowListOfFloors(expectedSize);
        when(floorRepository.findAllByRealEstate(RealEstateType.valueOf(floorDto.getRealEstate()))).thenReturn(resultSet);

        List<FloorDto> resultsetDto = floorService.findAllByRealEstate(floorDto);
        verify(floorMapper, times(expectedSize)).toDto(any(Floor.class));
        assertThat(resultsetDto.size()).isEqualTo(expectedSize);
    }
}