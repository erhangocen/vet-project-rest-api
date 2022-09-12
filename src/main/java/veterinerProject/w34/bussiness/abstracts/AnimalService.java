package veterinerProject.w34.bussiness.abstracts;

import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.Animal;

import java.util.List;

public interface AnimalService {

    Result add(Animal animal);
    Result update(Animal animal);
    Result delete(Animal animal);
    Result updatePhoto(int animalId, MultipartFile multipartFile);

    DataResult<List<Animal>> getAllByTypeId(int id, int pageNo, int pageSize);
    DataResult<List<Animal>> getAllByBreedId(int id, int pageNo, int pageSize);
    DataResult<List<Animal>> getAllByTypeId(int id);
    DataResult<List<Animal>> getAllByBreedId(int id);
    DataResult<List<Animal>> getAllByOwnerId(int id);

    DataResult<List<Animal>> getAll(int pageNo, int pageSize);
    DataResult<List<Animal>> getAll();

}
