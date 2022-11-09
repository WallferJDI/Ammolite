package com.knits.ammolite.service.mapper.partner;

import com.knits.ammolite.model.partner.FileUploader;
import com.knits.ammolite.service.dto.partner.FileUploaderDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface FileUploaderMapper extends EntityMapper<FileUploader, FileUploaderDto> {
}
