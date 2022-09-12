package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import veterinerProject.w34.entities.concretes.User;

import javax.persistence.criteria.From;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findById(int id);
    boolean existsByUsername(String username);
}
