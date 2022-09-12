package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.AnimalType;
import veterinerProject.w34.entities.concretes.Vet;

import java.util.List;

public interface VetDao extends JpaRepository<Vet, Integer> {
    List<Vet> findAllByOrderByIdAsc();
}
