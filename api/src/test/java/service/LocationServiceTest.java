package service;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.model.Ownership;
import com.knits.ammolite.model.RealEstate;
import com.knits.ammolite.repository.LocationRepository;
import com.knits.ammolite.service.LocationService;
import com.knits.ammolite.service.dto.LocationDto;
import com.knits.ammolite.service.mapper.LocationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LocationServiceTest {

    @Mock
    LocationRepository repository;

    @Mock
    LocationMapper mapper;

    @InjectMocks
    LocationService service;

    @Test
    void saveLocation() {
        Location location = Location.builder()
                .id(1l)
                .title("Tallinn")
                .address("address")
                .country(new Country(1l,"Country",new ArrayList<>()))
                .zipCode("12345")
                .realEstate(RealEstate.valueOf("OFFICE"))
                .ownership(Ownership.valueOf("OUR_PREMISES"))
                .mapCoordinates(false)
                .longitude("112233")
                .latitude("112233")
                .build();
        when(mapper.toEntity((LocationDto) any())).thenReturn(location);
        when(repository.save(ArgumentMatchers.any(Location.class))).thenReturn(location);
        LocationDto locationDto = mapper.toDto(location);
       service.createLocation(locationDto);
        verify(repository).save(location);
        verify(mapper).toEntity(locationDto);

    }
    @Test
    void checkIfLocationAlreadyExist(){
        Location location = Location.builder()
                .id(1l)
                .title("Tallinn")
                .country(new Country())
                .address("address")
                .zipCode("12345")
                .build();
        LocationDto locationDto = mapper.toDto(location);
        when(repository.findById(location.getId())).thenReturn(Optional.of(location));

        Location location2 = Location.builder()
                .id(1l)
                .title("Tallinn")
                .country(new Country())
                .address("address")
                .zipCode("12345")
                .build();
        LocationDto locationDto2 = mapper.toDto(location2);
        assertThrows(RuntimeException.class, () -> service.createLocation(locationDto2));
    }

    @Test
    void checkIfMandatoryFieldsAreNullOrEmpty() {
        Location location = Location.builder()
                .id(1l)
                .title(null)
                .country(null)
                .address("")
                .zipCode("")
                .build();
        LocationDto locationDto = mapper.toDto(location);
        when(repository.findById(location.getId())).thenReturn(Optional.of(location));
        assertThrows(RuntimeException.class, () -> service.createLocation(locationDto));
    }
}