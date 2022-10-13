package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.Provider;
import com.knits.ammolite.service.dto.asset.ProviderDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProviderMapper extends AbstractMapper<ProviderDto, Provider> {
}
