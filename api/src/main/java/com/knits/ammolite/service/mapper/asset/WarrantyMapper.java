package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.Warranty;
import com.knits.ammolite.service.dto.asset.WarrantyDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface WarrantyMapper extends AbstractMapper<WarrantyDto,Warranty> {
}
