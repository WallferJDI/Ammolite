package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.asset.AssetPart;
import com.knits.ammolite.service.dto.AssetPartDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetPartMapper extends AbstractMapper<AssetPartDto, AssetPart>{
}
