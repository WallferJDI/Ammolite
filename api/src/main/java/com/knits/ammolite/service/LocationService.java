package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.repository.LocationRepository;
import com.knits.ammolite.service.dto.LocationDto;
import com.knits.ammolite.service.mapper.CountryMapper;
import com.knits.ammolite.service.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class LocationService {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    private LocationRepository repository;
    @Autowired
    private LocationMapper mapper;

    @Autowired
    private CountryMapper countryMapper;

    public LocationDto createLocation(LocationDto locationDto) {
        log.debug("Request to create Location : {}", locationDto);
        checkIfNullOrEmpty(locationDto);
        Location location = mapper.toEntity(locationDto);
        repository.save(location);
        return mapper.toDto(location);
    }

    public LocationDto editLocation(LocationDto locationDto){
        log.debug("Request to edit Location : {}", locationDto);
        final Location locationFromDb = repository.findById(locationDto.getId()).get();
        if ( locationFromDb.getId()==null) {
            String message = "Location with id = " + locationDto.getId() + " does not exist.";
            log.warn(message);
            throw new RuntimeException(message);
        }
        mapper.update(locationDto,locationFromDb);
        repository.save(locationFromDb);
        return mapper.toDto(locationFromDb);
    }

    public void deleteLocation(Long id){
        log.debug("Set status deleted = true to Location Id: {}", id);
        repository.deleteById(id);
    }

    public List<LocationDto> findAllFilter(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedLocationFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<LocationDto> locations = mapper.toDtos(repository.findAll());
        session.disableFilter("deletedLocationFilter");
        return locations;
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
