package tacos.Repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.Domain.Ingredient;

public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {
}
