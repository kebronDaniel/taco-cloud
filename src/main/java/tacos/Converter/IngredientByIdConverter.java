package tacos.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;
import tacos.Service.IngredientTypeService;
import tacos.Service.IngredientsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<Integer, Ingredient> {

    @Autowired
    private IngredientsService ingredientsService;

    // This converter class is picked up by the application context and converts whenever it's needed without explicitly calling it.

    @Override
    public Ingredient convert(Integer id) {
        return ingredientsService.findById(id).orElse(null);
    }
}
