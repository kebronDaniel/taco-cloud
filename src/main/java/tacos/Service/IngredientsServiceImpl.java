package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Ingredient;
import tacos.Repositories.IngredientRepo;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientRepo ingredientRepo;

    @Override
    public List<Ingredient> getAllIngredients() {
        return (List<Ingredient>) ingredientRepo.findAll();
    }

    @Override
    public List<Ingredient> saveAll(List<Ingredient> ingredients) {
        return (List<Ingredient>) ingredientRepo.saveAll(ingredients);
    }

    @Override
    public Ingredient findById(int id) {
        return ingredientRepo.findById(id).orElse(null);
    }

    @Override
    public long count() {
        return ingredientRepo.count();
    }

    @Override
    public void deleteAll() {
        ingredientRepo.deleteAll();
    }
}
