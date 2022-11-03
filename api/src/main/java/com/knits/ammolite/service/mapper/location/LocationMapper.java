package com.knits.ammolite.service.mapper.location;

import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.service.dto.location.LocationDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",imports = {CountryMapper.class})
public interface LocationMapper {

   @Mapping(source = "ownership",target = "ownership")
   @Mapping(source = "realEstate",target = "realEstate")
    LocationDto toDto(Location location);

    @InheritInverseConfiguration
    Location toEntity (LocationDto locationDto);

    void update(LocationDto locationDto, @MappingTarget Location location);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(LocationDto locationDto, @MappingTarget Location location);

   @Mapping(source = "ownership",target = "ownership")
   @Mapping(source = "realEstate",target = "realEstate")
    List<LocationDto> toDtos(List<Location> locations);
   @InheritInverseConfiguration
    List<Location> toEntities (List<LocationDto> locationDtos);




}

