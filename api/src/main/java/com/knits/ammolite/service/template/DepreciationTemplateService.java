package com.knits.ammolite.service.template;


import com.knits.ammolite.dto.template.DepreciationTemplateDto;
import com.knits.ammolite.mapper.template.DepreciationTemplateMapper;
import com.knits.ammolite.model.template.DepreciationTemplate;
import com.knits.ammolite.model.template.WarrantyTemplate;
import com.knits.ammolite.repository.template.DepreciationTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepreciationTemplateService {

    private final DepreciationTemplateRepository repository;
    private final DepreciationTemplateMapper mapper;


    public DepreciationTemplateDto save(DepreciationTemplateDto templateDto){
        DepreciationTemplate template;
        if(repository.existsById(templateDto.getId())){
            template = repository.findById(templateDto.getId()).get();
        }else{
            template = repository.save(mapper.toEntity(templateDto));
        }
        return mapper.toDto(template);
    }

}
