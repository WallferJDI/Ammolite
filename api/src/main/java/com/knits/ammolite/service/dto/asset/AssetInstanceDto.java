package com.knits.ammolite.service.dto.asset;

import com.knits.ammolite.model.enums.AssetType;
import com.knits.ammolite.model.enums.ConditionType;
import com.knits.ammolite.model.enums.Ownership;
import com.knits.ammolite.model.enums.StateType;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AssetInstanceDto implements Serializable {
    private Long id;
    private AssetDto asset;
    private String serialNumber;
    private String tag;
    private String description;
    private String key;
    private ConditionType condition;
    private StateType state;
    private AssetType type;
    private Map<String,String> technicalSpecifications = new HashMap<>();
    private Ownership ownership;
    private String vendor;
    private OrderDto order;
    private Boolean depreciationAsset;
    private DepreciationDto depreciation;
    private WarrantyDto warranty;
    private List<DocumentDto> documents;
}
