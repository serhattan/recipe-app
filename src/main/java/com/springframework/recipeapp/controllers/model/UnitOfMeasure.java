package com.springframework.recipeapp.controllers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;

    public Long getId() {
        return id;
    }

    public String getUom() {
        return uom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
