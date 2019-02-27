package com.springframework.recipeapp.controllers.repositories;

import com.springframework.recipeapp.controllers.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
