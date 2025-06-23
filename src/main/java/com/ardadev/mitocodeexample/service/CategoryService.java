package com.ardadev.mitocodeexample.service;

import java.util.List;

import com.ardadev.mitocodeexample.models.Category;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    Category deleteCategory(Long id);
    List<Category> getAllCategories();
}
