package tacos.Domain;

import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final IngredientType type;

}
