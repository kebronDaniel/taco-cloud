package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Taco;
import tacos.Repositories.TacoRepo;

@Service
public class TacoServiceImpl extends CrudServiceImpl<Taco, Integer, TacoRepo> implements TacoService {
}
