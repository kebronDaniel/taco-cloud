package tacos.Controller;


import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.DTOs.RegistrationForm;
import tacos.Service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String register() {
        return "register";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userService.save(form.toUser());
        return "redirect:/login";
    }
}
