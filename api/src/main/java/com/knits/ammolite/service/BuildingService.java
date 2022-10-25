package com.knits.ammolite.service;

import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.building.Contact;
import com.knits.ammolite.model.building.Reception;
import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.repository.*;
import com.knits.ammolite.service.dto.UserDto;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.mapper.*;
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
    private ContactRepository contactRepository;
    @Autowired
    private SecurityContactRepository securityContactRepository;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private SecurityContactMapper securityContactMapper;
    @Autowired
    private ReceptionMapper receptionMapper;



    public BuildingDto create(BuildingDto buildingDto) {
        log.debug("Request to create Building : {}", buildingDto);
        checkForUniqueness(buildingDto);
        Building building = buildingMapper.toEntity(buildingDto);
        buildingRepository.save(building);
        return buildingMapper.toDto(building);
    }

    public List<BuildingDto> findAll() {
        return buildingRepository.findAll().stream().map(buildingMapper::toDto).collect(Collectors.toList());
    }

    public BuildingDto checkForUniqueness(BuildingDto buildingDto) {
        log.debug("Request to check Buildings fields for uniqueness : {}", buildingDto);
        Location location = locationRepository.findByTitle(buildingDto.getLocation().getTitle());
        Contact contact = contactRepository.findByPhone(buildingDto.getContact().getPhone());
        SecurityContact securityContact = securityContactRepository.findByPhone(buildingDto.getContact().getPhone());
        Reception reception = receptionRepository.findByPhone(buildingDto.getContact().getPhone());
        if(location!=null){
            log.info("Location for adding the Building already exists in DB");
        }
        if(contact!=null){
            log.info("Contact phone number already exists in DB");
        }
        if(securityContact!=null){
            log.info("Security contact phone number already exists in DB");
        }
        if(reception!=null){
            log.info("Reception phone number already exists in DB");
        }
        buildingDto.setLocation(locationMapper.toDto(location));
        return buildingDto;
}}
