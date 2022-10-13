package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.service.dto.CountryDto;
import com.knits.ammolite.service.dto.LocationDto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = {CountryMapper.class})
public interface LocationMapper {

   @Mapping(source = "location.ownership",target = "ownership")
   @Mapping(source = "location.realEstate",target = "realEstate")
    LocationDto toDto(Location location);

    @InheritInverseConfiguration
    Location toEntity (LocationDto locationDto);

    void update(LocationDto locationDto, @MappingTarget Location location);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(LocationDto locationDto, @MappingTarget Location location);

    @Mapping(source = "location.ownership",target = "ownership")
    @Mapping(source = "location.realEstate",target = "realEstate")
    List<LocationDto> toDtos(List<Location> locations);
    @InheritInverseConfiguration
    List<Location> toEntities (List<LocationDto> locationDtos);




}

