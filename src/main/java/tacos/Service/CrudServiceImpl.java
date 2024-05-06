package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class CrudServiceImpl<TEntity, TID extends Serializable, TRepository extends JpaRepository<TEntity, TID>> implements CrudService<TEntity, TID, TRepository> {

    @Autowired
    private TRepository repository;

    @Override
    public List<TEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TEntity> saveAll(List<TEntity> tEntities) {
        return repository.saveAll(tEntities);
    }

    @Override
    public TEntity save(TEntity tEntity) {
        return repository.save(tEntity);
    }

    @Override
    public Optional<TEntity> findById(TID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(TID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(TEntity tEntity) {
        repository.delete(tEntity);
    }

    @Override
    public void flushRepository() {
        repository.flush();
    }
}
