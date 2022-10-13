package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.AssetInstance;
import com.knits.ammolite.service.dto.asset.AssetInstanceDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AssetInstanceMapper extends AbstractMapper<AssetInstanceDto, AssetInstance> {
}
