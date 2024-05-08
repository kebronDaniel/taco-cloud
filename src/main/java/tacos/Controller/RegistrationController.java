package tacos.Controller;


import jakarta.servlet.Registration;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.DTOs.RegistrationForm;
import tacos.Domain.Taco;
import tacos.Domain.User;
import tacos.Service.RoleService;
import tacos.Service.UserService;

import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/register")
@SessionAttributes("RegistrationForm")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @ModelAttribute("RegistrationForm")
    public RegistrationForm registrationForm(Model model){
        return new RegistrationForm();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "register";
    }

    @PostMapping
    public String processRegistration(@Valid RegistrationForm form, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()){
            log.info("errors" + errors);
            return "register";
        }
        User user = form.toUser();
        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println("User name already exists");
            return "register";
        }
        user.addRole(roleService.findByName("ROLE_USER"));
        userService.save(user);
        sessionStatus.setComplete();
        return "login";

    }


}
