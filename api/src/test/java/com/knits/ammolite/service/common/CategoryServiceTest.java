package com.knits.ammolite.service.common;

import com.knits.ammolite.dto.asset.CategoryDto;
import com.knits.ammolite.mapper.asset.CategoryMapper;
import com.knits.ammolite.mapper.asset.CategoryMapperImpl;
import com.knits.ammolite.mocks.dto.common.CategoryDtoMock;
import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.repository.assets.CategoryRepository;
import com.knits.ammolite.service.asset.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;
    @Spy
    private CategoryMapper mapper = new CategoryMapperImpl();
    @Mock
    private CategoryRepository repository;
    @Captor
    private ArgumentCaptor<Category> captor;

    @Test
    @DisplayName("Save Category Success")
    void save() {
        CategoryDto inputCategoryDto = CategoryDtoMock.getAllFieldsCategoryDtoMock(1l);

        when(repository.save(Mockito.any(Category.class))).thenAnswer(element ->   element.getArguments()[0]);
        CategoryDto savedCategoryDto = categoryService.save(inputCategoryDto);

        verify(repository).save(captor.capture());
        Category toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputCategoryDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputCategoryDto).isEqualTo(savedCategoryDto);
    }
}