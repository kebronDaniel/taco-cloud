package tacos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.Domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
     User findByUsername(String username);
}
