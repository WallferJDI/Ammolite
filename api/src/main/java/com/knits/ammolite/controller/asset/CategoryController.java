package com.knits.ammolite.controller.asset;

import com.knits.ammolite.dto.asset.CategoryDto;
import com.knits.ammolite.service.asset.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/subcategory",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<CategoryDto> createSubcategory(@RequestBody CategoryDto subcategory){
        log.debug("REST request to create Subcategory");
        return ResponseEntity.ok()
                .body(categoryService.createSubcategory(subcategory));
    }

    @PostMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        log.debug("REST request to create Subcategory");
        return ResponseEntity.ok()
                .body(categoryService.save(categoryDto));
    }
}
