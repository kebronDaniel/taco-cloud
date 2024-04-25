package tacos.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tacos.Domain.User;

public interface UserService extends UserDetailsService {
    User save(User user);
}
