package tacos.Converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    // This converter class is picked up by the application context and converts whenever its needed without explicitly calling it.
    private Map<String, Ingredient> ingredientMap = new HashMap<String, Ingredient>();

    public IngredientByIdConverter() {
        ingredientMap.put
                ("FLTO", new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
        ingredientMap.put
                ("COTO", new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
        ingredientMap.put
                ("GRBF", new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
        ingredientMap.put
                ("CARN", new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
        ingredientMap.put
                ("TMTO", new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
        ingredientMap.put
                ("LETC", new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
        ingredientMap.put
                ("CHED", new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
        ingredientMap.put
                ("JACK", new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
        ingredientMap.put
                ("SLSA", new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
        ingredientMap.put
                ("SRCR", new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return this.ingredientMap.get(id);
    }
}
