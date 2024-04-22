package tacos.Repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.Domain.Taco;

public interface TacoRepo extends CrudRepository<Taco, Integer> {
}