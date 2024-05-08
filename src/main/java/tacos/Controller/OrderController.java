package tacos.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Domain.Taco;
import tacos.Domain.TacoOrder;
import tacos.Service.TacoOrderService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder") //This is to use the already defined tacoOrder object in the session. and later to close it.
public class OrderController {

    @Autowired
    TacoOrderService tacoOrderService;

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping()
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            System.out.println(errors);
            return "orderForm";
        }
        log.info("Processing order");
        log.info(String.valueOf(tacoOrder));
        tacoOrderService.save(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/removeTaco/{name}")
    public ResponseEntity<String> removeTaco(@PathVariable("name") String name, @ModelAttribute TacoOrder tacoOrder) {
        List<Taco> tacos = tacoOrder.getTacos();
        Taco taco = tacos.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
        tacoOrder.removeTaco(taco);
        if (tacoOrder.getTacos().size() == 0){
            return ResponseEntity.badRequest().body("There is nothing to remove from order");
        }
        return ResponseEntity.ok("Taco Removed");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllOrders() {
        log.info("Deleting All Orders");
        tacoOrderService.deleteAll();
        return ResponseEntity.ok("All Orders Deleted");
    }


}
