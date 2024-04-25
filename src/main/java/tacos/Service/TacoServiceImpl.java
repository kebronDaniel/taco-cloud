package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Repositories.TacoRepo;

@Service
public class TacoServiceImpl implements TacoService {

    @Autowired
    private TacoRepo tacoRepo;

    @Override
    public void deleteTaco(int id) {
        tacoRepo.deleteById(id);
    }
}
