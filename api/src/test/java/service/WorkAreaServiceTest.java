package service;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.WorkArea;
import com.knits.ammolite.mokcs.dto.WorkAreaDtoMock;
import com.knits.ammolite.repository.FloorRepository;
import com.knits.ammolite.repository.WorkAreaRepository;
import com.knits.ammolite.service.WorkAreaService;
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
    @DisplayName("Save Floor Success")
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
}
