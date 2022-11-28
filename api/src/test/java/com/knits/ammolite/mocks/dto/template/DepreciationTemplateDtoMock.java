package com.knits.ammolite.mocks.dto.template;

import com.knits.ammolite.dto.template.DepreciationTemplateDto;

import java.time.Month;

public class DepreciationTemplateDtoMock {

    public static DepreciationTemplateDto getAllFieldDto(Long id){
        DepreciationTemplateDto dto = new DepreciationTemplateDto();
        dto.setId(id);
        dto.setDepreciableCost(222);
        dto.setCurrentValue(2222);
        dto.setLifespan(Month.of(3));
        dto.setSalvation(3344);
        return dto;
    }

}
