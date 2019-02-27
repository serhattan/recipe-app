package com.springframework.recipeapp.controllers.repositories;

import com.springframework.recipeapp.controllers.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
