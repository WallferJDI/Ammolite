package com.knits.ammolite.repository.common;

import com.knits.ammolite.model.company.BinaryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploaderRepository extends JpaRepository<BinaryData, Long> {
}
