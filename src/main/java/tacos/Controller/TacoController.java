package tacos.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import tacos.Service.TacoOrderService;
import tacos.Service.TacoService;

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

    @Autowired
    private TacoService tacoService;

    @Autowired
    private TacoOrderService tacoOrderService;

    @ModelAttribute
    public void addIngredientToModel(Model model){

        List<Ingredient> ingredients = ingredientsService.findAll();

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

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type){
        return ingredients.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "design";
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

    @DeleteMapping("/taco/delete/{id}")
    public String deleteTaco(@PathVariable("id") int id, @ModelAttribute TacoOrder tacoOrder) {
        tacoService.deleteById(tacoOrder.getId());
        return "redirect:/design";
    }

    @GetMapping("/removeTaco/{name}")
    public ResponseEntity<String> showTaco(@PathVariable("name") String name, @ModelAttribute TacoOrder tacoOrder) {
        log.info("taco order " + tacoOrder);
        List<Taco> tacos = tacoOrder.getTacos();
        Taco taco = tacos.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
        tacoOrder.removeTaco(taco);
        log.info("taco order " + tacoOrder);
        return ResponseEntity.ok("Taco Removed");
    }
}

