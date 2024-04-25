package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tacos.Domain.User;
import tacos.Repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepo.findByUsername(username) == null) {
            throw new UsernameNotFoundException("User " + username+" not found!");
        }
        return userRepo.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
