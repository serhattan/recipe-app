package com.springframework.recipeapp.converters;

import com.springframework.recipeapp.commands.UnitOfMeasureCommand;
import com.springframework.recipeapp.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {

            final UnitOfMeasureCommand uomcommand = new UnitOfMeasureCommand();

            uomcommand.setId(unitOfMeasure.getId());
            uomcommand.setUom(unitOfMeasure.getUom());
            return uomcommand;
        }
        return null;
    }
}
