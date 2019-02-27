package com.springframework.recipeapp.controllers.repositories;

import com.springframework.recipeapp.controllers.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
