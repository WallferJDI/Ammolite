package com.knits.ammolite.mapper.asset;

import com.knits.ammolite.dto.asset.DepreciationDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.asset.Depreciation;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DepreciationMapper extends EntityMapper<DepreciationDto, Depreciation> {
}
