package tacos.Service;


import tacos.Domain.Taco;

public interface TacoService {
    Taco findById(int id);
    void deleteTaco(int id);
}
