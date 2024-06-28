package tacos.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Domain.TacoOrder;
import tacos.Domain.User;
import tacos.Service.TacoOrderService;

import java.util.List;

@Controller
@RequestMapping("/listOrders")
public class ListOrders {

    @Autowired
    private TacoOrderService tacoOrderService;

    @RequestMapping
    public String listOrders(Model model, @AuthenticationPrincipal User user) {
        System.out.println("user: " + user);
        List<TacoOrder> tacoOrder = tacoOrderService.findByUser(user);
        System.out.println("tacoOrder: ");
        for (TacoOrder tacoOrder1 : tacoOrder) {
            System.out.println(tacoOrder1);
        }
        model.addAttribute("orders", tacoOrderService.findByUser(user));
        model.addAttribute("user", user);
        return "listOrders";
    }

}
