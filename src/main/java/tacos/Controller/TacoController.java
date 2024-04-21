package tacos.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.Converter.IngredientByIdConverter;
import tacos.Domain.Ingredient;
import tacos.Domain.IngredientType;
import tacos.Domain.Taco;
import tacos.Domain.TacoOrder;
import tacos.Service.IngredientTypeService;
import tacos.Service.IngredientsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder") // this would make the tacoOrder object available across the entire session.
public class TacoController {

    @Autowired
    private IngredientsService ingredientsService;

    @Autowired
    private IngredientTypeService ingredientTypeService;

    @ModelAttribute
    public void addIngredientToModel(Model model){

        List<Ingredient> ingredients = ingredientsService.getAllIngredients();

        List<IngredientType> types = ingredientTypeService.findAll();

        for (IngredientType type : types) {
           model.addAttribute(type.getName().toString().toLowerCase(), filterByType(ingredients, type));
        }
        // this is more convenient way to add the model attribute this way because there are several of them being
        // bind to ingredients, so it's not a mapping between a single name to an object.
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
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder, @RequestParam(value = "action", required = false) String action) {

        if (errors.hasErrors()){
            System.out.println("errors" + errors);
            return "design";
        }
        tacoOrder.addTacos(taco);
        if ("add".equals(action)){
            log.info("Processing taco order ---------------- {}", taco);
            return "redirect:/design";
        }
        log.info("Processing taco order ---------------- {}", taco);
        return "redirect:/orders/current";
    }
}

