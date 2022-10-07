package service;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.model.OwnershipType;
import com.knits.ammolite.model.RealEstateType;
import com.knits.ammolite.mokcs.dto.LocationDtoMock;
import com.knits.ammolite.mokcs.model.LocationMock;
import com.knits.ammolite.repository.LocationRepository;
import com.knits.ammolite.service.LocationService;
import com.knits.ammolite.service.dto.CountryDto;
import com.knits.ammolite.service.dto.LocationDto;
import com.knits.ammolite.service.mapper.CountryMapper;
import com.knits.ammolite.service.mapper.CountryMapperImpl;
import com.knits.ammolite.service.mapper.LocationMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
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

    @Spy
    private final CountryMapper mapperCountry = new CountryMapperImpl();

    @Captor
    private ArgumentCaptor<Location> locationCaptor;

    @InjectMocks
    LocationService service;

    @Test
    @DisplayName("Save Location Success")
    void saveSuccess() {

        //1) create some mock data (make them reusable in ohter tests)

        LocationDto toSaveDto = LocationDtoMock.shallowLocationDto(null);

        //2) prepare mocks for everything they should return
        when(repository.save(Mockito.any(Location.class))) //any object of type User will match here
                .thenAnswer(i -> i.getArguments()[0]); //echo 1st parameter received

        //3) class under test
        LocationDto savedDto= service.create(toSaveDto);

        //4) use captor in spy/mocks for everything they get as input
        verify(repository).save(locationCaptor.capture());
        Location toSaveEntity = locationCaptor.getValue();

        //5) check if all dependencies were called (eventually with check on input data)
        verify(mapper, times(1)).toEntity(toSaveDto);
        verify(repository, times(1)).save(toSaveEntity);
        verify(mapper, times(1)).toDto(toSaveEntity);

        //6) assertions actual vs expected
        assertThat(toSaveDto).isEqualTo(savedDto); //not usually a good practice, but equals has override using all fields
    }

    @Test
    @DisplayName("Save User duplicated username")
    void saveShouldFailOnDuplicatedUsername() {
        //this need implementation to be changed first...
    }

    @Test
    @DisplayName("partial Update success")
    void partialUpdate (){

        Long entityIdToUpdate = 1L;
        String updateOnUserFirstName = "updatedTitleofLocation";

        Location foundEntity = LocationMock.shallowLocation(entityIdToUpdate);
        LocationDto toUpdateDto =mapper.toDto(foundEntity); //this is recorded therefore time expected is 2
        toUpdateDto.setTitle(updateOnUserFirstName);


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
        service.delete(entityIdToDelete);
    }

    @Test
    @DisplayName("findAll success")
    void findAllSuccess (){
        int expectedSize=10;
        List<Location> resultSet =LocationMock.shallowListOfLocation(expectedSize);
        when(repository.findAll()).thenReturn(resultSet);

        List<LocationDto> resultsetDto = service.findAll(false);
        verify(mapper, times(expectedSize)).toDto(any(Location.class));
        assertThat(resultsetDto.size()).isEqualTo(expectedSize);
    }
  /*  @Test
    void saveLocation() {
        Location location = Location.builder()
                .id(1l)
                .title("Tallinn")
                .address("address")
                .country(new Country(1l,"Country",new ArrayList<>()))
                .zipCode("12345")
                .realEstate(RealEstateType.valueOf("OFFICE"))
                .ownership(OwnershipType.valueOf("OUR_PREMISES"))
                .mapCoordinates(false)
                .longitude("112233")
                .latitude("112233")
                .build();
        when(mapper.toEntity((LocationDto) any())).thenReturn(location);
        when(repository.save(ArgumentMatchers.any(Location.class))).thenReturn(location);
        LocationDto locationDto = mapper.toDto(location);
       service.create(locationDto);
        verify(repository).save(location);
        verify(mapper).toEntity(locationDto);
    }*/
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
        assertThrows(RuntimeException.class, () -> service.create(locationDto2));
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
        assertThrows(RuntimeException.class, () -> service.create(locationDto));
    }

    @Test
    void updateMandatoryFieldsAtLocation(){
        Location location = Location.builder()
                .id(1l)
                .title("Tallinn")
                .address("address")
                .country(new Country(1l,"Country",new ArrayList<>()))
                .zipCode("12345")
                .realEstate(RealEstateType.valueOf("OFFICE"))
                .ownership(OwnershipType.valueOf("OUR_PREMISES"))
                .mapCoordinates(false)
                .longitude("112233")
                .latitude("112233")
                .build();
        when(repository.findById(any())).thenReturn(Optional.of(location));
        when(mapper.toDto((Location) any())).thenReturn(mock(LocationDto.class));
        LocationDto locationDto = mock(LocationDto.class);
        when(locationDto.getTitle()).thenReturn("Riga");
        when(locationDto.getAddress()).thenReturn("New Address");
        when(locationDto.getCountry()).thenReturn(new CountryDto(1l,"Latvia"));
        when(locationDto.getZipCode()).thenReturn("67891");
        service.update(locationDto);
        verify(repository).findById(any());
    }

    @Test
    void softDeleteLocationFromDb(){
        Location location = new Location();
        location.setId(1l);
        location.setDeleted(false);
        when(repository.findById(location.getId())).thenReturn(Optional.of(location));
        service.delete(location.getId());
        verify(repository).deleteById(location.getId());
    }




}