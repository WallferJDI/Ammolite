package com.knits.ammolite.service.dto.asset;

import com.knits.ammolite.model.enums.DocumentType;
import lombok.Data;

import java.io.Serializable;
import java.net.URL;

@Data
public class DocumentDto implements Serializable {
    private final Long id;
    private final String name;
    private final DocumentType type;
    private final URL link;
}
