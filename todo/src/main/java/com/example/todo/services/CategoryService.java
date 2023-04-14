package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.Category;
import com.example.todo.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service // класс является сервисом (бизнес-логика)
@Transactional // выполняется либо полностью, либо не выполняется
public class CategoryService {
    @Autowired // вызывает конструктор
    private CategoryRepository categoryRepository;

    // получение списка всех категорий в БД
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // сохранение категории в БД
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    // удаление категории из БД по id 
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

    // получение одной категории по id
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }
    
}
