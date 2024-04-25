package tacos.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;
import tacos.Repositories.IngredientTypeRepo;
import tacos.Service.IngredientTypeService;
import tacos.Service.IngredientsService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IngredientTypeService ingredientTypeService;

    @Autowired
    private IngredientsService ingredientsService;

    List<IngredientType> types = new ArrayList<IngredientType>();
    List<Ingredient> ingredients = new ArrayList<Ingredient>();

   @Override
   public void run(String... args) throws Exception {
       types = loadIngredientTypeData();
       ingredients = loadIngredientData();
   }

    public List<IngredientType> loadIngredientTypeData() {

        ingredientTypeService.deleteAll();
        types.add(new IngredientType("WRAP"));
        types.add(new IngredientType("PROTEIN"));
        types.add(new IngredientType("VEGGIES"));
        types.add(new IngredientType("CHEESE"));
        types.add(new IngredientType("SAUCE"));
        ingredientTypeService.saveAll(types);
        return types;
    }

    public List<Ingredient> loadIngredientData() {

        ingredientsService.deleteAll();
        ingredients.add(new Ingredient("FLTO", "Flour Tortilla", ingredientTypeService.findByName("WRAP")));
        ingredients.add(new Ingredient("COTO", "Corn Tortilla", ingredientTypeService.findByName("WRAP")));
        ingredients.add(new Ingredient("GRBF", "Ground Beef", ingredientTypeService.findByName("PROTEIN")));
        ingredients.add(new Ingredient("CARN", "Carnitas", ingredientTypeService.findByName("PROTEIN")));
        ingredients.add(new Ingredient("TMTO", "Diced Tomatoes", ingredientTypeService.findByName("VEGGIES")));
        ingredients.add(new Ingredient("LETC", "Lettuce", ingredientTypeService.findByName("VEGGIES")));
        ingredients.add(new Ingredient("CHED", "Cheddar", ingredientTypeService.findByName("CHEESE")));
        ingredients.add(new Ingredient("JACK", "Monterrey Jack", ingredientTypeService.findByName("CHEESE")));
        ingredients.add(new Ingredient("SLSA", "Salsa", ingredientTypeService.findByName("SAUCE")));
        ingredients.add(new Ingredient("SRCR", "Sour Cream", ingredientTypeService.findByName("SAUCE")));
        ingredients = ingredientsService.saveAll(ingredients);
        return ingredients;
    }

}
