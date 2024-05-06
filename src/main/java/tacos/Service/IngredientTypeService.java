package tacos.Service;

import tacos.Domain.IngredientType;
import tacos.Repositories.IngredientTypeRepo;

import java.util.List;

public interface IngredientTypeService extends CrudService<IngredientType, Integer, IngredientTypeRepo> {
    IngredientType findByName(String name);
}
