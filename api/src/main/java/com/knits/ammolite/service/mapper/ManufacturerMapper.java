package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.asset.Manufacturer;
import com.knits.ammolite.service.dto.ManufacturerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ManufacturerMapper {

    ManufacturerDto toDto(Manufacturer manufacturer);

    @InheritInverseConfiguration
    Manufacturer toEntity(ManufacturerDto manufacturerDto);
}
