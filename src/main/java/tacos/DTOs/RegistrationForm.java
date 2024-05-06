package tacos.DTOs;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.Domain.Ingredient;
import tacos.Domain.Role;
import tacos.Domain.User;
import tacos.Service.IngredientTypeService;
import tacos.Service.IngredientsService;
import tacos.Service.RoleService;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class RegistrationForm {

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @NotBlank(message = "username must not be blank")
    private String username;
    @NotBlank(message = "password must not be blank")
    private String password;
    @NotBlank(message = "Full Name must not be blank")
    private String fullName;
    @NotBlank(message = "Street must not be blank")
    private String street;
    @NotBlank(message = "city must not be blank")
    private String city;
    @NotBlank(message = "state must not be blank")
    private String state;
    @NotBlank(message = "zip must not be blank")
    private String zip;
    @Digits(fraction = 0, integer = 10, message = "Invalid Phone Number")
    private String phoneNumber;

    public User toUser(){
        User user =  new User(username, passwordEncoder.encode(password), fullName, street, city, state, zip, phoneNumber);
        return user;
    }

}
