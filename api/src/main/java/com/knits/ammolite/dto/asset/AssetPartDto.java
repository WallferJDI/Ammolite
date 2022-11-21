package com.knits.ammolite.dto.asset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetPartDto implements Serializable {
    private Long id;
    private String manufacturer;
    private String description;
    private String name;
    private String code;
    private CategoryDto category;
    private URL productUrl;
    private URL photoUrl;
    private Map<String,String> technicalSpecifications = new HashMap<>() ;
    private AssetDto parentAsset;
}