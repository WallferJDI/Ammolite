package com.knits.ammolite.mapper.template;

import com.knits.ammolite.dto.template.WarrantyTemplateDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.template.WarrantyTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WarrantyTemplateMapper
        extends EntityMapper<WarrantyTemplate,WarrantyTemplateDto> {
}
