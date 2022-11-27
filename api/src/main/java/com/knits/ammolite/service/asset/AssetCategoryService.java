package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.AssetCategoryDto;
import com.knits.ammolite.mapper.asset.AssetCategoryMapper;
import com.knits.ammolite.model.asset.AssetCategory;
import com.knits.ammolite.repository.assets.AssetCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AssetCategoryService {

    private final AssetCategoryMapper mapper;
    private final AssetCategoryRepository repository;

    public AssetCategoryDto save(AssetCategoryDto dto){
        log.debug("Request to save Asset Category  : {}", dto);
        AssetCategory assetCategory;
        if(repository.existsByName(dto.getName())){
            assetCategory = repository.findByName(dto.getName()).get();
        }else{
            assetCategory = repository.save(mapper.toEntity(dto));
        }
        return mapper.toDto(assetCategory);
    }

}
