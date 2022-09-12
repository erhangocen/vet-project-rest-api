package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.AnimalBreed;
import veterinerProject.w34.entities.concretes.AnimalOwner;

import java.util.List;

public interface AnimalOwnerDao extends JpaRepository<AnimalOwner, Integer> {
    AnimalOwner findById(int id);
    List<AnimalOwner> findAllByOrderByIdDesc(Pageable pageable);
    List<AnimalOwner> findAllByOrderByIdDesc();
}
