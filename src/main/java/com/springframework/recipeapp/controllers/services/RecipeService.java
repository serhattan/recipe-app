package com.springframework.recipeapp.controllers.services;

import com.springframework.recipeapp.controllers.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
