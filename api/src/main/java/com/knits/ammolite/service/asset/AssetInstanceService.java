package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.WarrantyDto;
import com.knits.ammolite.exceptions.SystemException;
import com.knits.ammolite.mapper.asset.WarrantyMapper;
import com.knits.ammolite.model.asset.AssetInstance;
import com.knits.ammolite.repository.assets.AssetInstanceRepository;
import com.knits.ammolite.dto.asset.AssetInstanceDto;
import com.knits.ammolite.mapper.asset.AssetInstanceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AssetInstanceService {
    private final AssetService assetService;

    private final AssetInstanceRepository assetInstanceRepository;
    private final AssetInstanceMapper assetInstanceMapper;

    private final WarrantyMapper warrantyMapper;

    public AssetInstanceDto save(AssetInstanceDto assetInstanceDto){
        log.debug("Request to save Asset : {}", assetInstanceDto);
        assetInstanceDto.setAsset(assetService.save(assetInstanceDto.getAsset()));
        AssetInstance assetInstance = assetInstanceRepository.save(assetInstanceMapper.toEntity(assetInstanceDto));
        return assetInstanceMapper.toDto(assetInstance);
    }
    
    public AssetInstanceDto addWarrantyToExistingInstance(AssetInstanceDto assetInstanceDto, WarrantyDto warrantyDto){
       AssetInstance found = assetInstanceRepository.findById(assetInstanceDto.getId()).orElseThrow(() ->
                new SystemException("Asset Instance with id "+assetInstanceDto.getId()+" not exist"));
       found.setWarranty(warrantyMapper.toEntity(warrantyDto));
       return save(assetInstanceMapper.toDto(found));
    }
}
