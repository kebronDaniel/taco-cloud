package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.IngredientType;
import tacos.Repositories.IngredientTypeRepo;

import java.util.List;

@Service
public class IngredientTypeServiceImpl extends CrudServiceImpl<IngredientType, Integer, IngredientTypeRepo> implements IngredientTypeService {

    @Autowired
    private IngredientTypeRepo ingredientTypeRepo;

    @Override
    public IngredientType findByName(String name) {
        return ingredientTypeRepo.findByName(name);
    }
}
