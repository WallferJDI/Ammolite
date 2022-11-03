package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.Depreciation;
import com.knits.ammolite.service.dto.asset.DepreciationDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DepreciationMapper extends AbstractMapper<DepreciationDto, Depreciation> {
}
