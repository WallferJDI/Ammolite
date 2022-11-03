package service;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.WorkArea;
import com.knits.ammolite.mokcs.dto.FloorDtoMock;
import com.knits.ammolite.mokcs.dto.WorkAreaDtoMock;
import com.knits.ammolite.mokcs.model.WorkAreaMock;
import com.knits.ammolite.repository.FloorRepository;
import com.knits.ammolite.repository.WorkAreaRepository;
import com.knits.ammolite.service.WorkAreaService;
import com.knits.ammolite.service.dto.FloorDto;
import com.knits.ammolite.service.dto.WorkAreaDto;
import com.knits.ammolite.service.mapper.FloorMapper;
import com.knits.ammolite.service.mapper.FloorMapperImpl;
import com.knits.ammolite.service.mapper.WorkAreaMapper;
import com.knits.ammolite.service.mapper.WorkAreaMapperImpl;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WorkAreaServiceTest {

    @Mock
    private WorkAreaRepository workAreaRepository;

    @Mock
    private FloorRepository floorRepository;
    @Spy
    private WorkAreaMapper workAreaMapper = new WorkAreaMapperImpl();

    @Spy
    private FloorMapper floorMapper = new FloorMapperImpl();

    @InjectMocks
    private WorkAreaService workAreaService;

    @Captor
    private ArgumentCaptor<WorkArea> workAreaCaptor;

    @Test
    @DisplayName("Save WorkArea Success")
    void saveSuccess() {

        WorkAreaDto toSaveDto = WorkAreaDtoMock.shallowWorkAreaDto(null);
        Floor floor = floorMapper.toEntity(toSaveDto.getFloor());
        floorRepository.save(floor);
        when(floorRepository.findById(toSaveDto.getFloor().getId())).thenReturn(Optional.of(floor));
        when(workAreaRepository.save(any(WorkArea.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        WorkAreaDto savedDto = workAreaService.create(toSaveDto);
        verify(workAreaRepository).save(workAreaCaptor.capture());
        WorkArea toSaveEntity = workAreaCaptor.getValue();

        verify(workAreaMapper, times(1)).toEntity(toSaveDto);
        verify(workAreaRepository, times(1)).save(toSaveEntity);
        verify(workAreaMapper, times(1)).toDto(toSaveEntity);

        assertThat(toSaveDto).isEqualTo(savedDto);
    }

    @Test
    @DisplayName("Delete WorkArea success")
    void deleteSuccess (){

        Long entityIdToDelete = 1L;
        WorkArea foundEntity = WorkAreaMock.shallowWorkArea(entityIdToDelete);
        WorkAreaDto toDeleteDto =workAreaMapper.toDto(foundEntity);
        when(workAreaRepository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));
        workAreaService.delete(entityIdToDelete);
        verify(workAreaRepository,times(1)).deleteById(entityIdToDelete);

    }

    @Test
    @DisplayName("Find All WorkArea By Floor number success")
    void findAllSuccess (){
        int expectedSize=10;
        FloorDto floorDto = FloorDtoMock.shallowFloorDto(1l);
        List<WorkArea> resultSet = WorkAreaMock.shallowListOfWorkAreas(expectedSize);
        when(workAreaRepository.findAllByFloor_FloorNumber(floorDto.getFloorNumber())).thenReturn(resultSet);

        List<WorkAreaDto> resultsetDto = workAreaService.findAllByFloorNumber(floorDto);
        verify(workAreaMapper, times(expectedSize)).toDto(any(WorkArea.class));
        assertThat(resultsetDto.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("partial Update success")
    void partialUpdate (){

        Long entityIdToUpdate = 1L;
        String updateRealEstate = "WAREHOUSE";
        WorkArea foundEntity = WorkAreaMock.shallowWorkArea(entityIdToUpdate);
        WorkAreaDto toUpdateDto =workAreaMapper.toDto(foundEntity);
        toUpdateDto.setRealEstate(updateRealEstate);
        when(workAreaRepository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));
        WorkAreaDto updatedDto =workAreaService.partialUpdate(toUpdateDto);

        verify(workAreaRepository).save(workAreaCaptor.capture());
        WorkArea toUpdateEntity = workAreaCaptor.getValue();

        verify(workAreaMapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(workAreaRepository, times(1)).save(foundEntity);
        verify(workAreaMapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);

    }

    @Test
    @DisplayName("Update Floor success")
    void updateSuccess (){

        Long entityIdToUpdate = 1L;
        String updateRealEstate = "WAREHOUSE";
        String updateRoomNumber = "2";

        WorkArea foundEntity = WorkAreaMock.shallowWorkArea(entityIdToUpdate);
        WorkAreaDto toUpdateDto =workAreaMapper.toDto(foundEntity);
        toUpdateDto.setRealEstate(updateRealEstate);
        toUpdateDto.setRoomNumber(updateRoomNumber);
        when(workAreaRepository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));
        WorkAreaDto updatedDto =workAreaService.partialUpdate(toUpdateDto);

        verify(workAreaRepository).save(workAreaCaptor.capture());
        WorkArea toUpdateEntity = workAreaCaptor.getValue();

        verify(workAreaMapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(workAreaRepository, times(1)).save(foundEntity);
        verify(workAreaMapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);
    }
}
