package tacos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.Domain.Taco;

public interface TacoRepo extends JpaRepository<Taco, Integer> {
}
