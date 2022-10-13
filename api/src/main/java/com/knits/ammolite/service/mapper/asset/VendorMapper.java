package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.asset.Vendor;
import com.knits.ammolite.service.dto.asset.VendorDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VendorMapper extends AbstractMapper<VendorDto, Vendor> {
}
