package tacos.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;
import tacos.Repositories.IngredientRepo;

public class Bootstrap implements CommandLineRunner {

    @Autowired
    private IngredientRepo ingredientRepo;

    @Override
    public void run(String... args) throws Exception {
        ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
        ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
        ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
        ingredientRepo.save(new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
        ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
        ingredientRepo.save(new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
        ingredientRepo.save(new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
        ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
        ingredientRepo.save(new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
        ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
    }
}
