package com.ardadev.mitocodeexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ardadev.mitocodeexample.models.Category;
import com.ardadev.mitocodeexample.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(new Category(0L, "No Category"));
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        category.setId(id);
        return categoryRepo.save(category);
    }

    @Override
    public Category deleteCategory(Long id) {
        Category category = getCategoryById(id);
        categoryRepo.delete(category);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    
}
