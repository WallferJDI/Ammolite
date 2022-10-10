package com.knits.ammolite.service;


import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.repository.AssetRepository;
import com.knits.ammolite.service.dto.AssetDto;
import com.knits.ammolite.service.mapper.AssetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    private final AssetMapper assetMapper;


    public AssetDto createAsset(AssetDto assetDto){
        log.debug("Request to save Asset : {}", assetMapper);
        Asset asset = assetMapper.toEntity(assetDto);
        assetRepository.save(asset);
        return assetMapper.toDto(asset);

    }
}
