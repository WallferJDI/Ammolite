package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.LocationException;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.repository.LocationRepository;
import com.knits.ammolite.search.LocationSearchDto;
import com.knits.ammolite.service.dto.location.LocationDto;
import com.knits.ammolite.service.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
            throw new LocationException(message);
        }
        mapper.update(locationDto,locationFromDb);
        repository.save(locationFromDb);
        return mapper.toDto(locationFromDb);
    }

    public LocationDto partialUpdate (LocationDto locationDto){
        log.debug("Request to partial update Location : {}", locationDto);
        Location location = repository.findById(locationDto.getId()).orElseThrow(() -> new LocationException("Location#" + locationDto.getId() + " not found"));
        mapper.partialUpdate(locationDto, location);
        repository.save(location);
        return mapper.toDto(location);
    }

    public void delete(Long id){
        log.debug("Set status deleted = true to Location Id: {}", id);
        repository.deleteById(id);}

    public List<LocationDto> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedLocationFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<LocationDto> locationsDtos = mapper.toDtos(repository.findAll());
        session.disableFilter("deletedLocationFilter");
        return locationsDtos;
    }

    public Page<LocationDto> search(LocationSearchDto locationSearch) {
        Page<Location> locationPage = repository.findAll(locationSearch.getSpecification(), locationSearch.getPageable());
        List<LocationDto> locationDtos = mapper.toDtos(locationPage.getContent());
        return new PageImpl<>(locationDtos, locationSearch.getPageable(), locationPage.getTotalElements());
    }



}
