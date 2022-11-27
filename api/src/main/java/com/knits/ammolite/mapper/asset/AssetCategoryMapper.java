package com.knits.ammolite.mapper.asset;

import com.knits.ammolite.dto.asset.AssetCategoryDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.asset.AssetCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetCategoryMapper extends EntityMapper<AssetCategory, AssetCategoryDto> {
}
