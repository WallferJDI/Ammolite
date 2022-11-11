package com.knits.ammolite.controller.common;

import com.knits.ammolite.dto.common.BinaryDataDto;
import com.knits.ammolite.service.partner.FileUploaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file-uploader")
@Slf4j
public class FileUploaderController {

    @Autowired
    private FileUploaderService service;

    @PostMapping("/upload")
    public ResponseEntity<BinaryDataDto> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok().body(service.upload(file));
    }
}
