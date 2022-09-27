package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.User;
import com.knits.ammolite.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {


    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User entity = new User();
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setActive(dto.getActive());
        return entity;
    }

    public UserDto toDto(User entity) {

        if (entity == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setActive(entity.getActive());
        return dto;
    }

    public void partialUpdate(User entity, UserDto dto) {
        if (dto == null) {
            return;
        }
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getLogin() != null) {
            entity.setLogin(dto.getLogin());
        }
        if (dto.getFirstName() != null) {
            entity.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            entity.setLastName(dto.getLastName());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }

    public void update(User entity, UserDto dto) {
        if (dto == null) {
            return;
        }
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.getActive());
    }

    public List<UserDto> toDto(List<User> entityList) {
        if (entityList == null) {
            return null;
        }

        List<UserDto> list = new ArrayList<>(entityList.size());
        for (User entity : entityList) {
            list.add(toDto(entity));
        }
        return list;
    }

    public List<User> toEntity(List<UserDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<User> list = new ArrayList<>(dtoList.size());
        for (UserDto userDTO : dtoList) {
            list.add(toEntity(userDTO));
        }
        return list;
    }

}
