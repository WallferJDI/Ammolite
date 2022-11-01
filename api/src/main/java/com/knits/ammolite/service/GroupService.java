package com.knits.ammolite.service;

import com.knits.ammolite.model.Group;
import com.knits.ammolite.repository.GroupRepository;
import com.knits.ammolite.service.dto.GroupDto;
import com.knits.ammolite.service.mapper.GroupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GroupService {

    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    public GroupDto createGroup(GroupDto groupDto){
        log.debug("Request to save Group : {}", groupDto);

        Group group;
        if(groupRepository.existsById(groupDto.getId())){
            group = groupRepository.findById(groupDto.getId()).get();
        }else{
            group =  groupRepository.save(groupMapper.toEntity(groupDto));
        }
        return groupMapper.toDto(group);
    }

}
