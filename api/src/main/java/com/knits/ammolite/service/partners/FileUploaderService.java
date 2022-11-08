package com.knits.ammolite.service.partners;

import com.knits.ammolite.model.partner.FileUploader;
import com.knits.ammolite.repository.common.FileUploaderRepository;
import com.knits.ammolite.service.dto.partner.FileUploaderDto;
import com.knits.ammolite.service.mapper.partner.FileUploaderMapper;
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

    public FileUploaderDto upload(MultipartFile file) throws IOException {

        FileUploaderDto fileUploaderDto = new FileUploaderDto();
        fileUploaderDto.setSize(file.getSize());
        fileUploaderDto.setTitle(file.getName());
        fileUploaderDto.setContentType(file.getContentType());
        fileUploaderDto.setBytes(file.getBytes());
        FileUploader fileUploader = mapper.toEntity(fileUploaderDto);
        repository.save(fileUploader);
        return mapper.toDto(fileUploader);
    }

}
