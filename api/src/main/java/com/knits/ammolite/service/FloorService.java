package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.BuildingException;
import com.knits.ammolite.exceptions.FloorException;
import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.model.location.RealEstateType;
import com.knits.ammolite.repository.FloorRepository;
import com.knits.ammolite.repository.building.BuildingRepository;
import com.knits.ammolite.service.dto.FloorDto;
import com.knits.ammolite.service.mapper.FloorMapper;
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
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private FloorMapper floorMapper;

    public FloorDto create(FloorDto floorDto) {
        log.debug("Request to create Floor : {}", floorDto);
        buildingRepository.findById(floorDto.getBuilding().getId()).orElseThrow(() -> new BuildingException("Building #" + floorDto.getBuilding().getId() + " not found"));
        Floor floor = floorMapper.toEntity(floorDto);
        floorRepository.save(floor);
        return floorMapper.toDto(floor); }

    public List<FloorDto> findAllByRealEstate(FloorDto floorDto) {
        return floorRepository.findAllByRealEstate(RealEstateType.valueOf(floorDto.getRealEstate())).stream().map(floorMapper::toDto).collect(Collectors.toList());
    }

    public FloorDto update(FloorDto floorDto){
        log.debug("Request to edit Floor : {}", floorDto);
        final Floor floorFromDb = floorRepository.findById(floorDto.getId()).get();
        if (floorFromDb.getId()==null) {
            String message = "Floor with id = " + floorDto.getId() + " does not exist.";
            log.warn(message);
        }
        floorMapper.update(floorFromDb,floorDto);
        floorRepository.save(floorFromDb);
        return floorMapper.toDto(floorFromDb);
    }

    public FloorDto partialUpdate (FloorDto floorDto){
        log.debug("Request to partial Update Floor : {}", floorDto);
        Floor floor = floorRepository.findById(floorDto.getId()).orElseThrow(() -> new FloorException("Floor " + floorDto.getId() + " not found"));
        floorMapper.partialUpdate(floor, floorDto);
        floorRepository.save(floor);
        return floorMapper.toDto(floor);
    }

    public void delete(Long id){
        log.debug("Set status deleted = true to Floor Id: {}", id);
        floorRepository.deleteById(id);}

}
