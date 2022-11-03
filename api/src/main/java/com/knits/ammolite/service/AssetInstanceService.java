package com.knits.ammolite.service;

import com.knits.ammolite.model.asset.AssetInstance;
import com.knits.ammolite.repository.AssetInstanceRepository;
import com.knits.ammolite.service.dto.asset.AssetInstanceDto;
import com.knits.ammolite.service.mapper.asset.AssetInstanceMapper;
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

    public AssetInstanceDto save(AssetInstanceDto assetInstanceDto){
        log.debug("Request to save Asset : {}", assetInstanceDto);
        assetInstanceDto.setAsset(assetService.save(assetInstanceDto.getAsset()));
        AssetInstance assetInstance = assetInstanceRepository.save(assetInstanceMapper.toEntity(assetInstanceDto));
        return assetInstanceMapper.toDto(assetInstance);
    }
}
