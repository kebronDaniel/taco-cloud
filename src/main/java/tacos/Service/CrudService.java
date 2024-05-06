package tacos.Service;

import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudService <TEntity, TID extends Serializable, TRepository extends CrudRepository<TEntity, TID>> {

    List<TEntity> findAll();
    List<TEntity> saveAll(List<TEntity> entities);
    TEntity save(TEntity entity);
    Optional<TEntity> findById(TID id);
    void deleteById(TID id);
    void deleteAll();
    long count();
    void delete(TEntity entity);
    void flushRepository();
}
