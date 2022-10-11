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

    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    public AssetDto createAsset(AssetDto assetDto){
        log.debug("Request to save Asset : {}", assetMapper);
        assetDto.setCategory(categoryService.save(assetDto.getName()));
        assetDto.setManufacturer(manufacturerService.save(assetDto.getManufacturer().getName()));
        Asset asset = assetMapper.toEntity(assetDto);
        assetRepository.save(asset);
        return assetMapper.toDto(asset);

    }
}
