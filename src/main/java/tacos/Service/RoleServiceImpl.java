package tacos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Domain.Role;
import tacos.Repositories.RoleRepo;

import java.util.List;

@Service
public class RoleServiceImpl extends CrudServiceImpl<Role, Integer, RoleRepo> implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
