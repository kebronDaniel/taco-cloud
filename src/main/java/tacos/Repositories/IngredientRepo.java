package tacos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.Domain.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {
}
