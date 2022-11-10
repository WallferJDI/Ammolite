package com.knits.ammolite.service.location;

import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.dto.location.WorkAreaDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.mapper.location.WorkAreaMapper;
import com.knits.ammolite.model.location.WorkArea;
import com.knits.ammolite.repository.location.FloorRepository;
import com.knits.ammolite.repository.location.WorkAreaRepository;
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
public class WorkAreaService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private WorkAreaRepository workAreaRepository;

    @Autowired
    private WorkAreaMapper workAreaMapper;

    public WorkAreaDto create(WorkAreaDto workAreaDto) {
        log.debug("Request to create Work Area : {}", workAreaDto);
        floorRepository.findById(workAreaDto.getFloor().getId()).orElseThrow(() -> new UserException("Floor #" + workAreaDto.getFloor().getId() + " not found"));
        WorkArea workArea = workAreaMapper.toEntity(workAreaDto);
        workAreaRepository.save(workArea);
        return workAreaMapper.toDto(workArea); }

    public List<WorkAreaDto> findAllByFloorNumber(FloorDto floorDto) {
        return workAreaRepository.findAllByFloor_FloorNumber(floorDto.getFloorNumber()).stream().map(workAreaMapper::toDto).collect(Collectors.toList());
    }

    public void delete(Long id){
        log.debug("Set status deleted = true to WorkArea Id: {}", id);
        workAreaRepository.deleteById(id);}

    public WorkAreaDto update(WorkAreaDto workAreaDto){
        log.debug("Request to edit Work Area : {}", workAreaDto);
        final WorkArea workAreaFromDb = workAreaRepository.findById(workAreaDto.getId()).get();
        if (workAreaFromDb.getId()==null) {
            String message = "Work Area with id = " + workAreaDto.getId() + " does not exist.";
            log.warn(message);
        }
        workAreaMapper.update(workAreaFromDb,workAreaDto);
        workAreaRepository.save(workAreaFromDb);
        return workAreaMapper.toDto(workAreaFromDb);
    }

    public WorkAreaDto partialUpdate (WorkAreaDto workAreaDto){
        log.debug("Request to partial Update Work Area : {}", workAreaDto);
        WorkArea workArea = workAreaRepository.findById(workAreaDto.getId()).orElseThrow(() -> new UserException("Work Area " + workAreaDto.getId() + " not found"));
        workAreaMapper.partialUpdate(workArea, workAreaDto);
        workAreaRepository.save(workArea);
        return workAreaMapper.toDto(workArea);
    }
}
