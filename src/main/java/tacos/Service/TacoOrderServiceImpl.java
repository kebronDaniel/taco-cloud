package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.TacoOrder;
import tacos.Domain.User;
import tacos.Repositories.TacoOrderRepo;

import java.util.List;

@Service
public class TacoOrderServiceImpl extends CrudServiceImpl<TacoOrder, Integer, TacoOrderRepo> implements TacoOrderService {

    @Autowired
    private TacoOrderRepo tacoOrderRepo;

    @Override
    public List<TacoOrder> findByUser(User user) {
        return tacoOrderRepo.findByUser(user);
    }
}
