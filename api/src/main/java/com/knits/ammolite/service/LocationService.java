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
@Slf4j
@RequiredArgsConstructor
@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

    private LocationMapper mapper;

    public void createLocation(LocationDto locationDto) {
        checkIfNullOrEmpty(locationDto);
        repository.save(mapper.toEntity(locationDto));
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
