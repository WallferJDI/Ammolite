package com.knits.ammolite.service.dto;

import com.knits.ammolite.service.dto.asset.AssetDto;
import lombok.Data;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
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
