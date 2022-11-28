package com.knits.ammolite.service.template;

import com.knits.ammolite.dto.template.WarrantyTemplateDto;
import com.knits.ammolite.mapper.template.WarrantyTemplateMapper;
import com.knits.ammolite.model.template.WarrantyTemplate;
import com.knits.ammolite.repository.template.WarrantyTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WarrantyTemplateService {

    private final WarrantyTemplateMapper mapper;
    private final WarrantyTemplateRepository repository;

    public WarrantyTemplateDto save(WarrantyTemplateDto templateDto){
        WarrantyTemplate warrantyTemplate;
        if(repository.existsById(templateDto.getId())){
            warrantyTemplate = repository.findById(templateDto.getId()).get();
        }else{
            warrantyTemplate = repository.save(mapper.toEntity(templateDto));
        }
        return mapper.toDto(warrantyTemplate);
    }
}
