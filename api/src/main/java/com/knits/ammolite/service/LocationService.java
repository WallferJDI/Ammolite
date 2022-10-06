package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.model.User;
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

    public LocationDto create(LocationDto locationDto) {
        log.debug("Request to create Location : {}", locationDto);
        Location location = mapper.toEntity(locationDto);
        repository.save(location);
        return mapper.toDto(location);
    }

    public LocationDto update(LocationDto locationDto){
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

    public LocationDto partialUpdate (LocationDto locationDto){
        log.debug("Request to partialUpdate Location : {}", locationDto);
        Location location = repository.findById(locationDto.getId()).orElseThrow(() -> new UserException("Location#" + locationDto.getId() + " not found"));
        mapper.partialUpdate(locationDto, location);
        repository.save(location);
        return mapper.toDto(location);
    }



    public void delete(Long id){
        log.debug("Set status deleted = true to Location Id: {}", id);
        repository.deleteById(id);
    }

    public List<LocationDto> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedLocationFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<LocationDto> locations = mapper.toDtos(repository.findAll());
        session.disableFilter("deletedLocationFilter");
        return locations;
    }



}
