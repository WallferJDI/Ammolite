package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.repository.LocationRepository;
import com.knits.ammolite.service.dto.LocationDto;
import com.knits.ammolite.service.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;
    @Autowired
    private LocationMapper mapper;

    public LocationDto createLocation(LocationDto locationDto) {
        log.debug("Request to create Location : {}", locationDto);
        checkIfNullOrEmpty(locationDto);
        Location location = mapper.toEntity(locationDto);
        repository.save(location);
        return mapper.toDto(location);
    }
    @Transactional
    public LocationDto editLocation(LocationDto locationDto){
        log.debug("Request to edit Location : {}", locationDto);
        checkIfNullOrEmpty(locationDto);
        final Long idLocation = locationDto.getId();
        final Location locationFromDb = repository.findById(idLocation).get();
        if ( locationFromDb== null) {
            String message = "Location with id = " + idLocation + " does not exist.";
            log.warn(message);
            throw new RuntimeException(message);
        }
        locationFromDb.builder()
                .title(locationDto.getTitle())
                .country(mapper.toEntity(locationDto.getCountry()))
                .address(locationDto.getAddress())
                .zipCode(locationDto.getZipCode());
        return mapper.toDto(locationFromDb);
    }

    public void deleteLocation(Long id){
        log.debug("Set status deleted = true to Location Id: {}", id);
        repository.deleteById(id);
    }


    public void checkIfNullOrEmpty(LocationDto locationDto){
        String title = locationDto.getTitle();
        String country = String.valueOf(locationDto.getCountry());
        String address = locationDto.getAddress();
        String zipCode = locationDto.getZipCode();
        if(title==null||title.isEmpty()){
            String titleMessage = "Title can`t be null or empty";
            log.warn(titleMessage);
            throw new UserException(titleMessage);
        } if (country==null||country.isEmpty()){
            String countryMessage = "Country can`t be null or empty";
            log.warn(countryMessage);
            throw new UserException(countryMessage);}
        if (address==null||address.isEmpty()){
            String addressMessage = "Address can`t be null or empty";
            log.warn(addressMessage);
            throw new UserException(addressMessage);}
        if (zipCode==null||zipCode.isEmpty()){
            String zipCodeMessage = "ZipCode can`t be null or empty";
            log.warn(zipCodeMessage);
            throw new UserException(zipCodeMessage);}
    }


}
