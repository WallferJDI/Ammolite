package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.Source;
import com.knits.ammolite.service.dto.asset.SourceDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface SourceMapper extends AbstractMapper<SourceDto, Source> {
}
