package tacos.Service;

import tacos.Domain.TacoOrder;
import tacos.Domain.User;
import tacos.Repositories.TacoOrderRepo;

import java.util.List;

public interface TacoOrderService extends CrudService<TacoOrder, Integer, TacoOrderRepo> {
    List<TacoOrder> findByUser(User user);
}
