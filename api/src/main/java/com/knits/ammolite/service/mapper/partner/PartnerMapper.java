package com.knits.ammolite.service.mapper.partner;

import com.knits.ammolite.model.partner.*;
import com.knits.ammolite.service.dto.partner.PartnerDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface PartnerMapper extends EntityMapper<Partner, PartnerDto> {
}
