package com.knits.ammolite.repository;

import com.knits.ammolite.model.partner.FileUploader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploaderRepository extends JpaRepository<FileUploader, Long> {
}
