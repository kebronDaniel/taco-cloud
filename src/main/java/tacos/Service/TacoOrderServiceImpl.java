package tacos.Service;

import org.springframework.stereotype.Service;
import tacos.Domain.TacoOrder;
import tacos.Repositories.TacoOrderRepo;

@Service
public class TacoOrderServiceImpl extends CrudServiceImpl<TacoOrder, Integer, TacoOrderRepo> implements TacoOrderService {
}
