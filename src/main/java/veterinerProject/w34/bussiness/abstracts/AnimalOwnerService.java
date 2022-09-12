package veterinerProject.w34.bussiness.abstracts;

import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.AnimalOwner;

import java.util.List;

public interface AnimalOwnerService {

    Result add(AnimalOwner animalOwner);
    Result update(AnimalOwner animalOwner);
    Result delete(AnimalOwner animalOwner);
    Result updatePhoto(int ownerId, MultipartFile multipartFile);

    DataResult<List<AnimalOwner>> getAll();
    DataResult<List<AnimalOwner>> getAll(int pageNo, int pageSize);
    DataResult<AnimalOwner> getById(int id);

}
