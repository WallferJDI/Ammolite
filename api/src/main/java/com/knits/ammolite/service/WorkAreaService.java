package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.WorkAreaException;
import com.knits.ammolite.model.WorkArea;
import com.knits.ammolite.repository.FloorRepository;
import com.knits.ammolite.repository.WorkAreaRepository;
import com.knits.ammolite.service.dto.WorkAreaDto;
import com.knits.ammolite.service.mapper.WorkAreaMapper;
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
        floorRepository.findById(workAreaDto.getFloor().getId()).orElseThrow(() -> new WorkAreaException("Floor #" + workAreaDto.getFloor().getId() + " not found"));
        WorkArea workArea = workAreaMapper.toEntity(workAreaDto);
        workAreaRepository.save(workArea);
        return workAreaMapper.toDto(workArea); }

    public List<WorkAreaDto> findAll() {
        return workAreaRepository.findAll().stream().map(workAreaMapper::toDto).collect(Collectors.toList());
    }

    public void delete(Long id){
        log.debug("Set status deleted = true to WorkArea Id: {}", id);
        workAreaRepository.deleteById(id);}
}
