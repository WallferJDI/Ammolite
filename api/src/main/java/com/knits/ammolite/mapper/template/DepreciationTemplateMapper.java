package com.knits.ammolite.mapper.template;

import com.knits.ammolite.dto.template.DepreciationTemplateDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.template.DepreciationTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DepreciationTemplateMapper
        extends EntityMapper<DepreciationTemplate, DepreciationTemplateDto> {
}
