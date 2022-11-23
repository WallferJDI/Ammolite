package com.knits.ammolite.service.asset;

import com.knits.ammolite.dto.asset.CategoryDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.mapper.asset.CategoryMapper;
import com.knits.ammolite.mapper.asset.CategoryMapperImpl;
import com.knits.ammolite.mocks.dto.common.CategoryDtoMock;
import com.knits.ammolite.model.asset.AssetInstance;
import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.repository.assets.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CategoryServiceTest {


    @InjectMocks
    private CategoryService categoryService;
    @Spy
    private CategoryMapper  mapper = new CategoryMapperImpl();
    @Mock
    private CategoryRepository repository;
    @Captor
    private ArgumentCaptor<Category> captor;

    @Test
    @DisplayName("Save Category")
    void save() {
        CategoryDto inputCategoryDto = CategoryDtoMock.getSubcategoryDtoMock(1l);
        when(repository.save(Mockito.any(Category.class))).thenAnswer(e -> e.getArguments()[0]);

        CategoryDto savedEntity = categoryService.save(inputCategoryDto);
        verify(repository).save(captor.capture());
        Category categoryCaptor = captor.getValue();

        verify(mapper,times(1)).toEntity(inputCategoryDto);
        verify(repository,times(1)).save(categoryCaptor);
        verify(mapper,times(1)).toDto(categoryCaptor);

        assertThat(inputCategoryDto).isEqualTo(savedEntity);
    }

    @Test
    @DisplayName("Create subcategory")
    void createSubcategory() {
        CategoryDto inputSubcategoryDto = CategoryDtoMock.getSubcategoryDtoMock(1l);

        when(repository.findByName(Mockito.any(String.class))).thenAnswer(e -> Optional.empty());
        when(repository.existsByName(Mockito.any(String.class))).thenAnswer(e -> true);
        when(repository.save(Mockito.any(Category.class))).thenAnswer(e -> e.getArguments()[0]);
        CategoryDto savedEntity = categoryService.createSubcategory(inputSubcategoryDto);


        verify(repository,times(2)).save(captor.capture());
        List<Category> categoryCaptorDtos = captor.getAllValues();
        verify(mapper,times(2)).toEntity(inputSubcategoryDto);
        verify(repository,times(1)).existsByName(categoryCaptorDtos.get(0)
                .getParentCategory().getName());
        assertThat(inputSubcategoryDto).isEqualTo(savedEntity);
    }
    @Test
    @DisplayName("Subcategory: Parent not exist exception")
    void createCategoryWithNotExistParentCategory(){
        CategoryDto inputSubcategoryDto = CategoryDtoMock.getSubcategoryDtoMock(1l);
        when(repository.existsByName(Mockito.any(String.class))).thenAnswer(e -> false);
        assertThatThrownBy(() ->categoryService.createSubcategory(inputSubcategoryDto))
                .isInstanceOf(UserException.class);
        verify(repository,never()).save(any());
    }
}