package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.AnimalBreed;
import veterinerProject.w34.entities.concretes.AnimalType;

import java.util.List;

public interface AnimalBreedDao extends JpaRepository<AnimalBreed, Integer> {
    List<AnimalBreed> findAllByAnimalType_Id(int id);
    List<AnimalBreed> findAllByOrderByIdAsc();
}
