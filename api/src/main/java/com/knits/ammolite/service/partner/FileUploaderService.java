package com.knits.ammolite.service.partner;

import com.knits.ammolite.model.company.BinaryData;
import com.knits.ammolite.repository.common.FileUploaderRepository;
import com.knits.ammolite.dto.common.BinaryDataDto;
import com.knits.ammolite.mapper.common.FileUploaderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class FileUploaderService {

    @Autowired
    private FileUploaderRepository repository;

    @Autowired
    private FileUploaderMapper mapper;

    public BinaryDataDto upload(MultipartFile file) throws IOException {

        BinaryDataDto fileUploaderDto = new BinaryDataDto();
        fileUploaderDto.setSize(file.getSize());
        fileUploaderDto.setTitle(file.getName());
        fileUploaderDto.setContentType(file.getContentType());
        fileUploaderDto.setBytes(file.getBytes());
        BinaryData fileUploader = mapper.toEntity(fileUploaderDto);
        repository.save(fileUploader);
        return mapper.toDto(fileUploader);
    }

}
