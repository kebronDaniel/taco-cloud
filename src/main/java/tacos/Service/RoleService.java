package tacos.Service;


import tacos.Domain.Role;
import tacos.Repositories.RoleRepo;

import java.util.List;

public interface RoleService extends CrudService<Role, Integer, RoleRepo> {
    Role findByName(String name);
}
