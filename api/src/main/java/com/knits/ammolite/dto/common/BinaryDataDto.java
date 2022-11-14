package com.knits.ammolite.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BinaryDataDto {

    private Long id;

    private String title;

    private Long size;

    private String contentType;

    private byte[] bytes;
}
