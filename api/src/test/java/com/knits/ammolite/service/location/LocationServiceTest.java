package com.knits.ammolite.service.location;

import com.knits.ammolite.dto.location.LocationDto;
import com.knits.ammolite.mapper.location.LocationMapper;
import com.knits.ammolite.mocks.dto.LocationDtoMock;
import com.knits.ammolite.mocks.model.LocationMock;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.repository.location.LocationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LocationServiceTest {

    @Mock
    LocationRepository repository;

    @Spy
    private LocationMapper mapper;

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

        verify(mapper, times(1)).partialUpdate(toUpdateEntity,toUpdateDto);
        verify(repository, times(1)).save(foundEntity);
        verify(mapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);

    }

    @Test
    @DisplayName("delete success")
    void deleteSuccess (){

        Long entityIdToDelete = 1L;
        Location foundEntity = LocationMock.shallowLocation(entityIdToDelete);
        LocationDto toDeleteDto =mapper.toDto(foundEntity);
        when(repository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));
        service.delete(entityIdToDelete);
        verify(repository,times(1)).deleteById(entityIdToDelete);

    }
}