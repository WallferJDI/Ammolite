package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.service.dto.asset.AssetDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AssetMapper extends AbstractMapper<AssetDto,Asset> {
}
