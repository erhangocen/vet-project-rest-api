package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
}
