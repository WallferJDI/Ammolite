package com.knits.ammolite.service;


import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.repository.CategoryRepository;
import com.knits.ammolite.service.dto.CategoryDto;
import com.knits.ammolite.service.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryDto save(String name){
        Category category = new Category();

        if(repository.findByName(name).isEmpty()){
            category.setName(name);
            repository.save(category);
        }else{
            category = repository.findByName(name).get();
        }
        return mapper.toDto(category);
    }
}
