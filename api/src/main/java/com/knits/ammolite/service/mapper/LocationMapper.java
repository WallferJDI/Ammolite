package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.service.dto.CountryDto;
import com.knits.ammolite.service.dto.LocationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = {CountryMapper.class})
public interface LocationMapper {

   @Mapping(source = "location.ownership",target = "ownership")
   @Mapping(source = "location.realEstate",target = "realEstate")
    LocationDto toDto(Location location);

    @InheritInverseConfiguration
    Location toEntity (LocationDto locationDto);

    default List<LocationDto> toDtos(List<Location> entities){
        if (entities == null){
            return null;
        }
        return entities.stream()
                .map(entity->toDto(entity)).collect(Collectors.toList());
    }

    default List<Location> toEntities(List<LocationDto> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream()
                .map(dto->toEntity(dto)).collect(Collectors.toList());}




}

