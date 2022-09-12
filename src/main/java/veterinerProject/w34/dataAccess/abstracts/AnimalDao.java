package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.Animal;
import veterinerProject.w34.entities.concretes.AnimalBreed;

import java.util.List;

public interface AnimalDao extends JpaRepository<Animal, Integer> {
    Animal findById(int id);
    List<Animal> findAllByAnimalBreed_AnimalType_Id(int id, Pageable pageable);
    List<Animal> findAllByAnimalBreed_AnimalType_Id(int id);
    List<Animal> findAllByAnimalBreed_Id(int id, Pageable pageable);
    List<Animal> findAllByAnimalBreed_Id(int id);
    List<Animal> findAllByAnimalOwner_Id(int id);
    List<Animal> findAllByOrderByIdDesc();
    List<Animal> findAllByOrderByIdDesc(Pageable pageable);
}
