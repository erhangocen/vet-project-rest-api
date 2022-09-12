package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role,Integer> {
    public Role findByRoleName(String name);
}
