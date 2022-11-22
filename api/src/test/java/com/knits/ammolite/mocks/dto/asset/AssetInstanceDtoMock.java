package com.knits.ammolite.mocks.dto.asset;

import com.knits.ammolite.dto.asset.AssetInstanceDto;
import com.knits.ammolite.mocks.dto.common.AddressDtoMock;
import com.knits.ammolite.model.enums.AssetDepreciationType;
import com.knits.ammolite.model.enums.ConditionType;
import com.knits.ammolite.model.enums.Ownership;
import com.knits.ammolite.model.enums.StateType;

import java.util.HashMap;

public class AssetInstanceDtoMock {

    public static AssetInstanceDto getAllFieldDto(Long id){
        return AssetInstanceDto.builder()
                .id(id)
                .asset(AssetDtoMock.getAllFieldAssetDtoMock(id))
                .serialNumber("44342353532")
                .tag("taag")
                .barcode("565756--4523-543-5")
                .description("lorem ispum")
                .key("44-4-444-4")
                .condition(ConditionType.Average)
                .state(StateType.Active)
                .type(AssetDepreciationType.Capitalized)
                .technicalSpecifications(new HashMap<>())
                .ownership(Ownership.Owned)
                .depreciationAsset(false)
                .address(AddressDtoMock.getAddressDtoAllFields(id))
                .build();
    }
}
