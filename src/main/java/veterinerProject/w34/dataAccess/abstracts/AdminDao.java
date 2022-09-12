package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
}
