package tacos.Repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.Domain.IngredientType;

public interface IngredientTypeRepo extends CrudRepository<IngredientType, Integer> {
    IngredientType findByName(String name);
}
