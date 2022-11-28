package com.knits.ammolite.mapper.template;

import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.dto.template.AssetTemplateDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.template.AssetTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AssetTemplateMapper extends EntityMapper<AssetTemplate, AssetTemplateDto> {
}
