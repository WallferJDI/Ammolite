package com.knits.ammolite.service.asset;


import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.repository.assets.CategoryRepository;
import com.knits.ammolite.dto.asset.CategoryDto;
import com.knits.ammolite.mapper.asset.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryDto save(CategoryDto categoryDto){
        Category category;
        if(repository.findByName(categoryDto.getName()).isEmpty()){
            category = repository.save(mapper.toEntity(categoryDto));
        }else{
            category = repository.findByName(categoryDto.getName()).get();
        }
        return mapper.toDto(category);
    }
}
