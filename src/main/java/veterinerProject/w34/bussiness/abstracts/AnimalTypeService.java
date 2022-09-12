package veterinerProject.w34.bussiness.abstracts;

import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.AnimalType;

import java.util.List;

public interface AnimalTypeService {

    Result add(AnimalType animalType);
    Result update(AnimalType animalType);
    Result delete(AnimalType animalType);
    Result updatePhoto(int animalTypeId, MultipartFile multipartFile);
    DataResult<List<AnimalType>> getAll();
}
