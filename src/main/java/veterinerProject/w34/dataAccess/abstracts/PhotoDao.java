package veterinerProject.w34.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinerProject.w34.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
    Photo findByPhotoId(int id);
}
