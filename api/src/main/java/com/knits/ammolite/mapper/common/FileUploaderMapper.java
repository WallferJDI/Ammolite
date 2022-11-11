package com.knits.ammolite.mapper.common;

import com.knits.ammolite.model.company.BinaryData;
import com.knits.ammolite.dto.common.BinaryDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface FileUploaderMapper extends EntityMapper<BinaryData, BinaryDataDto> {
}
