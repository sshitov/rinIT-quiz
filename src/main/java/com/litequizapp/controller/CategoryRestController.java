package com.litequizapp.controller;

import com.litequizapp.dto.CategoryDTO;
import com.litequizapp.entity.CategoryEntity;
import com.litequizapp.service.CategoryRestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

  private final CategoryRestService restService;

  @Autowired
  public CategoryRestController(CategoryRestService restService) {
    this.restService = restService;
  }


  @GetMapping
  public ResponseEntity<List<CategoryEntity>> getAllCategories() {

    return ResponseEntity.ok(restService.getAllCategories());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryEntity> getCategoryByIdRequest(@PathVariable String id) {
    long categoryId = Long.parseLong(id);
    return ResponseEntity.ok(restService.getCategoryById(categoryId));
  }


  @PutMapping
  public CategoryDTO createCategoryRequest(@RequestBody CategoryDTO categoryDTO) {
    return restService.createCategory(categoryDTO);
  }


  @PostMapping(value = "/{id}")
  public CategoryDTO updateCategoryRequest(@PathVariable String id, @RequestBody CategoryDTO categoryDTO) {
    long categoryId = Long.parseLong(id);
    return restService.updateCategory(categoryId, categoryDTO);

  }

  @DeleteMapping(value = "/{id}")
  public void deleteCategoryByIdRequest(@PathVariable String id) {
    long categoryId = Long.parseLong(id);
    restService.deleteCategory(categoryId);

  }


}
