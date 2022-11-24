package com.knits.ammolite.service.asset;


import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.asset.Asset;
import com.knits.ammolite.repository.assets.AssetRepository;
import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.mapper.asset.AssetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
    public AssetDto partialUpdate(AssetDto assetDto){
        log.debug("Request to partially update Asset ",assetDto);
        Asset asset = assetRepository.findById(assetDto.getId())
                .orElseThrow(() -> new UserException("Asset with id "+assetDto.getId() +" not exist"));
        assetMapper.partialUpdate(asset,assetDto);
        return assetMapper.toDto(assetRepository.save(asset));
    }

    public List<AssetDto> getAllAssets(){
        return assetMapper.toDtos(assetRepository.findAll()) ;
    }
}
