package com.knits.ammolite.mapper.asset;

import com.knits.ammolite.dto.asset.AssetPartDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.asset.AssetPart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetPartMapper extends EntityMapper<AssetPart,AssetPartDto > {
}
