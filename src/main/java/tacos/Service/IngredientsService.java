package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;
import tacos.Repositories.IngredientRepo;

import java.util.List;

public interface IngredientsService {
    List<Ingredient> getAllIngredients();

    List<Ingredient> saveAll(List<Ingredient> ingredients);

    Ingredient findById(int id);

    long count();

    void deleteAll();

}