package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.annotations.ValidURL;
import com.knits.ammolite.config.Views;
import com.knits.ammolite.model.enums.DocumentType;
import lombok.Data;

import java.io.Serializable;
import java.net.URL;

@Data
@JsonView(Views.Public.class)
public class DocumentDto implements Serializable {
    private Long id;
    private String name;
    private DocumentType type;
    @ValidURL
    private String link;
}
