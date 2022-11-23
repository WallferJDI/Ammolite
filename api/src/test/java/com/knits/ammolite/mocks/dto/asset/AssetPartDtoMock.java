package com.knits.ammolite.mocks.dto.asset;

import com.knits.ammolite.dto.asset.AssetPartDto;

public class AssetPartDtoMock {


    public static AssetPartDto getAllFieldsDtoMock(Long id){
        AssetPartDto assetPartDto = new AssetPartDto();
        assetPartDto.setId(id);
        assetPartDto.setParentAsset(AssetDtoMock.getAllFieldAssetDtoMock(id));
        System.out.println(assetPartDto);
        return assetPartDto;
    }
}
