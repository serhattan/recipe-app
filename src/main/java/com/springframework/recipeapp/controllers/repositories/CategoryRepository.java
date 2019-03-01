package com.springframework.recipeapp.controllers.repositories;

import com.springframework.recipeapp.controllers.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
