package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Taco;
import tacos.Repositories.TacoRepo;

@Service
public class TacoServiceImpl implements TacoService {

    @Autowired
    private TacoRepo tacoRepo;

    @Override
    public Taco findById(int id) {
        return tacoRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteTaco(int id) {
        tacoRepo.deleteById(id);
    }

}
