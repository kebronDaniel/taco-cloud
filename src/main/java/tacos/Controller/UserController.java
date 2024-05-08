package tacos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tacos.Domain.User;
import tacos.Service.RoleService;
import tacos.Service.UserService;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    // This means if the one getting it's data if he is an admin or he is only looking his own data.
    @PostAuthorize("hasRole('ROLE_ADMIN') || returnObject.getUsername().equals(authentication.getName())")
    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()){
            return user;
        }
        else return null;
    }
}
