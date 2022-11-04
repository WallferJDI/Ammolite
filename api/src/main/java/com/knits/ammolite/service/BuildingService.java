package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.BuildingException;
import com.knits.ammolite.model.location.Building;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.repository.building.BuildingRepository;
import com.knits.ammolite.repository.location.LocationRepository;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.dto.location.LocationDto;
import com.knits.ammolite.service.mapper.building.BuildingMapper;
import com.knits.ammolite.service.mapper.location.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private LocationMapper locationMapper;


    public BuildingDto create(BuildingDto buildingDto) {
        log.debug("Request to create Building : {}", buildingDto);
        Location location = locationRepository.findByTitle(buildingDto.getLocation().getTitle());
        if(location!=null){
            log.info("Location for adding the Building already exists in DB");
        }
        buildingDto.setLocation(locationMapper.toDto(location));
        Building building = buildingMapper.toEntity(buildingDto);
        buildingRepository.save(building);
        return buildingMapper.toDto(building);
    }

    public List<BuildingDto> findAllByLocation(LocationDto locationDto) {
        return buildingRepository.findAllByLocation_Title(locationDto.getTitle()).stream().map(buildingMapper::toDto).collect(Collectors.toList());
    }

    public BuildingDto update(BuildingDto buildingDto){
        log.debug("Request to edit Building : {}", buildingDto);
        final Building buildingFromDb = buildingRepository.findById(buildingDto.getId()).get();
        if (buildingFromDb.getId()==null) {
            String message = "Building with id = " + buildingDto.getId() + " does not exist.";
            log.warn(message);
        }
        buildingMapper.update(buildingFromDb,buildingDto);
        buildingRepository.save(buildingFromDb);
        return buildingMapper.toDto(buildingFromDb);
    }

    public BuildingDto partialUpdate (BuildingDto buildingDto){
        log.debug("Request to partialUpdate Building : {}", buildingDto);
        Building building = buildingRepository.findById(buildingDto.getId()).orElseThrow(() -> new BuildingException("Building#" + buildingDto.getId() + " not found"));
        buildingMapper.partialUpdate(building, buildingDto);
        buildingRepository.save(building);
        return buildingMapper.toDto(building);
    }

    public void delete(Long id){
        log.debug("Set status deleted = true to Building Id: {}", id);
        buildingRepository.deleteById(id);
}}
