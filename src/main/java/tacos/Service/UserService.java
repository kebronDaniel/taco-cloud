package tacos.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tacos.Domain.User;
import tacos.Repositories.UserRepo;

public interface UserService extends UserDetailsService, CrudService<User, Integer, UserRepo> {
    User findByUsername(String username);
}
