package tacos.Service;

import tacos.Domain.IngredientType;

import java.util.List;

public interface IngredientTypeService {
    IngredientType findByName(String name);
    Iterable<IngredientType> saveAll(List<IngredientType> types);

    List<IngredientType> findAll();
    long count();
    void deleteAll();
}
