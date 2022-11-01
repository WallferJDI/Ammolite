package com.knits.ammolite.service;

import com.knits.ammolite.model.asset.AssetPart;
import com.knits.ammolite.repository.AssetPartRepository;
import com.knits.ammolite.service.dto.AssetPartDto;
import com.knits.ammolite.service.mapper.AssetPartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AssetPartService {

    private final AssetPartRepository assetPartRepository;
    private final AssetPartMapper assetPartMapper;

    private final AssetService assetService;
    private final CategoryService categoryService;

    public AssetPartDto save(AssetPartDto assetPartDto){
        log.debug("Request to save Asset : {}", assetPartDto);
        AssetPart assetPart;
        assetPartDto.setParentAsset(assetService.save(assetPartDto.getParentAsset()));
        assetPartDto.setCategory(categoryService.save(assetPartDto.getCategory()));
        if(assetPartRepository.existsById(assetPartDto.getId())){
            assetPart = assetPartRepository.findById(assetPartDto.getId()).get();
        }else {
            assetPart = assetPartRepository.save(assetPartMapper.toEntity(assetPartDto));
        }
        return assetPartMapper.toDto(assetPart);
    }
}
