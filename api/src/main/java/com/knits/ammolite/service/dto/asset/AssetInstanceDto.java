package com.knits.ammolite.service.dto.asset;


import com.knits.ammolite.model.enums.Condition;
import com.knits.ammolite.model.enums.State;
import com.knits.ammolite.model.enums.Type;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AssetInstanceDto {
    private Long id;
    private AssetDto asset;
    private String serialNumber;
    private String tag;
    private String barcode;
    private String description;
    private String key;
    private Condition condition;
    private State state;
    private Type type;
    private Map<String,String> technicalSpecifications = new HashMap<>();
    private SourceDto source;
    private DepreciationDto depreciation;
    private WarrantyDto warranty;


}
