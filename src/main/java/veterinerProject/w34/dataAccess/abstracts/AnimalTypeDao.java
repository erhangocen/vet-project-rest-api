package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.AnimalType;

import java.util.List;

public interface AnimalTypeDao extends JpaRepository<AnimalType, Integer> {
    AnimalType findById(int id);

    List<AnimalType> findAllByOrderByIdAsc();
}
