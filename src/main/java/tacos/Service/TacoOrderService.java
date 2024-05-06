package tacos.Service;

import tacos.Domain.TacoOrder;
import tacos.Repositories.TacoOrderRepo;

public interface TacoOrderService extends CrudService<TacoOrder, Integer, TacoOrderRepo> {
}
