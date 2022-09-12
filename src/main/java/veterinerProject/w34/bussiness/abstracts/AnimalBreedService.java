package veterinerProject.w34.bussiness.abstracts;

import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.AnimalBreed;

import java.util.List;

public interface AnimalBreedService {

    Result add(AnimalBreed animalBreed);
    Result update(AnimalBreed animalBreed);
    Result delete(AnimalBreed animalBreed);

    DataResult<List<AnimalBreed>> getAll();
    DataResult<List<AnimalBreed>> getAllByTypeId(int id);
}
