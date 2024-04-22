package tacos.Service;

import tacos.Domain.Taco;
import tacos.Domain.TacoOrder;

public interface TacoOrderService {
    TacoOrder findById(int id);
    void deleteTacoOrder(int id);
}
