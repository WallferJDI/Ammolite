package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.service.dto.AssetDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AssetMapper {

   AssetDto toDto(Asset asset);

    @InheritInverseConfiguration
    Asset toEntity(AssetDto assetDto);
}
