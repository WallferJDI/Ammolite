package service;

import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.mokcs.dto.LocationDtoMock;
import com.knits.ammolite.mokcs.model.LocationMock;
import com.knits.ammolite.repository.LocationRepository;
import com.knits.ammolite.service.LocationService;
import com.knits.ammolite.service.dto.location.LocationDto;
import com.knits.ammolite.service.mapper.LocationMapper;
import com.knits.ammolite.service.mapper.LocationMapperImpl;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LocationServiceTest {

    @Mock
    LocationRepository repository;

    @Spy
    private final LocationMapper mapper = new LocationMapperImpl();

    @Captor
    private ArgumentCaptor<Location> locationCaptor;

    @InjectMocks
    LocationService service;

    @Test
    @DisplayName("Save Location Success")
    void saveSuccess() {

        LocationDto toSaveDto = LocationDtoMock.shallowLocationDto(null);

        when(repository.save(Mockito.any(Location.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        LocationDto savedDto= service.create(toSaveDto);

        verify(repository).save(locationCaptor.capture());
        Location toSaveEntity = locationCaptor.getValue();

        verify(mapper, times(1)).toEntity(toSaveDto);
        verify(repository, times(1)).save(toSaveEntity);
        verify(mapper, times(1)).toDto(toSaveEntity);

        assertThat(toSaveDto).isEqualTo(savedDto);
    }

    @Test
    @DisplayName("partial Update success")
    void partialUpdate (){

        Long entityIdToUpdate = 1L;
        String updateOnTitleofLocation = "updatedTitleofLocation";
        Location foundEntity = LocationMock.shallowLocation(entityIdToUpdate);
        LocationDto toUpdateDto =mapper.toDto(foundEntity);
        toUpdateDto.setTitle(updateOnTitleofLocation);

        when(repository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));

        LocationDto updatedDto =service.partialUpdate(toUpdateDto);

        verify(repository).save(locationCaptor.capture());
        Location toUpdateEntity = locationCaptor.getValue();

        verify(mapper, times(1)).partialUpdate(toUpdateDto,toUpdateEntity);
        verify(repository, times(1)).save(foundEntity);
        verify(mapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);

    }

    @Test
    @DisplayName("delete success")
    void deleteSuccess (){
        Long entityIdToDelete = 1L;
        Location foundEntity = LocationMock.shallowLocation(entityIdToDelete);
        foundEntity.setDeleted(true);
        LocationDto toUpdateDto =mapper.toDto(foundEntity);
        when(repository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));
        service.delete(toUpdateDto.getId());
        verify(repository, times(1)).save(foundEntity);
        assertSame(foundEntity.isDeleted(),toUpdateDto.isDeleted());
    }
}