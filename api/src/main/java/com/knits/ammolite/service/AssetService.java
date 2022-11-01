package com.knits.ammolite.service;


import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.repository.AssetRepository;
import com.knits.ammolite.service.dto.asset.AssetDto;
import com.knits.ammolite.service.mapper.asset.AssetMapper;
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

    private final CategoryService categoryService;

    public AssetDto save(AssetDto assetDto){
        log.debug("Request to save Asset : {}", assetDto);
        Asset asset;
        assetDto.setCategory(categoryService.save(assetDto.getCategory()));
        if(assetRepository.existsById(assetDto.getId())){
            asset = assetRepository.findById(assetDto.getId()).get();
        }else{
            asset = assetRepository.save(assetMapper.toEntity(assetDto)) ;
        }
        return assetMapper.toDto(asset);

    }
}
