package com.springframework.recipeapp.controllers.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }
}