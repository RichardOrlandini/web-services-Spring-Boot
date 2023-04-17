package com.richardorlandini.curse.services;

import com.richardorlandini.curse.entities.Category;
import com.richardorlandini.curse.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepositories repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
       Optional<Category> obj = repository.findById(id);
       return obj.get();//retornando um obj do tipo user
    }

}
