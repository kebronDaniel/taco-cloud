package tacos.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.Converter.IngredientByIdConverter;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;
import tacos.Domain.Taco;
import tacos.Domain.TacoOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class TacoController {

    @ModelAttribute
    public void addIngredientToModel(Model model){

        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
            new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
            new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
            new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
            new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
            new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
            new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
            new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));


        IngredientType[] types = IngredientType.values();

        for (IngredientType type : types) {
           model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        // this is more convenient way to add the model attribute this way because there are several of them being
        // bind to ingredients so it's not a mapping between a single name to an object.
    }

    @ModelAttribute("tacoOrder")
    public TacoOrder tacoOrder(Model model){
        return new TacoOrder();
    }

    @ModelAttribute("taco")
    public Taco taco(Model model){
        return new Taco();
    }

    @GetMapping("")
    public String showDesignForm(){return "/design";}

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type){
        return ingredients.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder){
        tacoOrder.addTacos(taco);
        log.info("Processing taco order ---------------- {}", taco);
        return "redirect:/orders/current";
    }

}
