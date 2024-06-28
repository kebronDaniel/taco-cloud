package tacos.Service;

import tacos.Domain.Taco;
import tacos.Domain.TacoOrder;
import tacos.Repositories.TacoRepo;

public interface TacoService extends CrudService<Taco, Integer, TacoRepo> {

}
