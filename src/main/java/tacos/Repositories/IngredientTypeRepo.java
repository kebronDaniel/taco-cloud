package tacos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.Domain.IngredientType;

public interface IngredientTypeRepo extends JpaRepository<IngredientType, Integer> {
    IngredientType findByName(String name);
}
