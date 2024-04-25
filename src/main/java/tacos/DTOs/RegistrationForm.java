package tacos.DTOs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.Domain.User;

@Data
public class RegistrationForm {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String username;
    private final String password;
    private final String fullName;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String phoneNumber;

    public User toUser(){
        return new User(username, passwordEncoder.encode(password), fullName, street, city, state, zip, phoneNumber);
    }

}
