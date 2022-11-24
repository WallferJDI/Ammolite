package com.knits.ammolite.service.template;

import com.knits.ammolite.dto.template.AssetTemplateDto;
import com.knits.ammolite.mapper.template.AssetTemplateMapper;
import com.knits.ammolite.model.template.AssetTemplate;
import com.knits.ammolite.repository.assets.AssetRepository;
import com.knits.ammolite.repository.template.AssetTemplateRepository;
import com.knits.ammolite.service.asset.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class AssetTemplateService {

    private final AssetTemplateMapper mapper;

    private final AssetTemplateRepository repository;
    private final CategoryService categoryService;

    public AssetTemplateDto createAssetTemplate(AssetTemplateDto assetTemplateDto){
        AssetTemplate asset;
        assetTemplateDto.setCategory(categoryService.save(assetTemplateDto.getCategory()));
        if(repository.existsById(assetTemplateDto.getId())){
            asset = repository.findById(assetTemplateDto.getId()).get();
        }else{
            asset = repository.save(mapper.toEntity(assetTemplateDto)) ;
        }
        return mapper.toDto(asset);
    }
}
