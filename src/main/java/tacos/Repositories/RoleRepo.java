package tacos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.Domain.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
