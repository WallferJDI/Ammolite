package com.knits.ammolite.mapper.partner;

import com.knits.ammolite.dto.partner.PartnerDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.partner.Partner;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface PartnerMapper extends EntityMapper<Partner, PartnerDto> {
}
