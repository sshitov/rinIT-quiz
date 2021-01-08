package com.litequizapp.server;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryRestService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryRestService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public String getCategoryById(long id) {
    CategoryEntity category = categoryRepository.findById(id);
    return category.toString();

  }

  public List<String> getAllCategory() {
    List<String> categories = new ArrayList<>();
    for (CategoryEntity category : categoryRepository.findAll()) {
      categories.add(category.toString());
    }
    return categories;

  }

  public void createCategory(String title) {
    categoryRepository.save(new CategoryEntity(title));
  }

  public void updateCategory(long id, String title) {
    CategoryEntity category = categoryRepository.findById(id);
    category.setTitle(title);
    categoryRepository.save(category);
  }

  public void deleteCategory(long id) {
    categoryRepository.deleteById(id);

  }

}
