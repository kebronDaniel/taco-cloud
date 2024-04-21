package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.IngredientType;
import tacos.Repositories.IngredientTypeRepo;

import java.util.List;

@Service
public class IngredientTypeServiceImpl implements IngredientTypeService {

    @Autowired
    private IngredientTypeRepo ingredientTypeRepo;

    @Override
    public IngredientType findByName(String name) {
        return ingredientTypeRepo.findByName(name);
    }

    @Override
    public List<IngredientType> saveAll(List<IngredientType> types) {
        return (List<IngredientType>) ingredientTypeRepo.saveAll(types);
    }

    @Override
    public List<IngredientType> findAll() {
        return (List<IngredientType>) ingredientTypeRepo.findAll();
    }


    @Override
    public long count() {
        return ingredientTypeRepo.count();
    }


    @Override
    public void deleteAll() {
        ingredientTypeRepo.deleteAll();
    }
}
