package com.ardadev.mitocodeexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardadev.mitocodeexample.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {}
