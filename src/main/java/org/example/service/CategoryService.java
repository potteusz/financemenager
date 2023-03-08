package org.example.service;

import org.example.DbConnection;
import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(String categoryName) {
        if(!categoryName.isEmpty()) {
            Category category = new Category(categoryName);
            categoryRepository.insertCategory(category);
        } else throw new IllegalArgumentException("Category name can not be empty");
    }



}
