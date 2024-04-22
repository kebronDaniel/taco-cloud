package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Taco;
import tacos.Domain.TacoOrder;
import tacos.Repositories.TacoOrderRepo;

@Service
public class TacoOrderServiceImpl implements TacoOrderService {

    @Autowired
    TacoOrderRepo tacoOrderRepo;

    @Override
    public TacoOrder findById(int id) {
        return tacoOrderRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteTacoOrder(int id) {
        tacoOrderRepo.deleteById(id);
    }
}
