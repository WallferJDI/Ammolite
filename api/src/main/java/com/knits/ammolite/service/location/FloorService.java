package com.knits.ammolite.service.location;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.model.enums.LocationUsageType;
import com.knits.ammolite.repository.location.FloorRepository;
import com.knits.ammolite.repository.location.BuildingRepository;
import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.mapper.location.FloorMapper;
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
        buildingRepository.findById(floorDto.getBuilding().getId()).orElseThrow(() -> new UserException("Building #" + floorDto.getBuilding().getId() + " not found"));
        Floor floor = floorMapper.toEntity(floorDto);
        floorRepository.save(floor);
        return floorMapper.toDto(floor); }

    public List<FloorDto> findAllByRealEstate(FloorDto floorDto) {
        return floorRepository.findAllByRealEstate(LocationUsageType.valueOf(floorDto.getRealEstate())).stream().map(floorMapper::toDto).collect(Collectors.toList());
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
        Floor floor = floorRepository.findById(floorDto.getId()).orElseThrow(() -> new UserException("Floor " + floorDto.getId() + " not found"));
        floorMapper.partialUpdate(floor, floorDto);
        floorRepository.save(floor);
        return floorMapper.toDto(floor);
    }

    public void delete(Long id){
        log.debug("Set status deleted = true to Floor Id: {}", id);
        floorRepository.deleteById(id);}

}
