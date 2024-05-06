package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Ingredient;
import tacos.Repositories.IngredientRepo;

import java.util.List;

@Service
public class IngredientsServiceImpl extends CrudServiceImpl<Ingredient, Integer, IngredientRepo> implements IngredientsService {
}
