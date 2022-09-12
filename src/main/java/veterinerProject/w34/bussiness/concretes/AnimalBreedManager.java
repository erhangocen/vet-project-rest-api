package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinerProject.w34.bussiness.abstracts.AnimalBreedService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.AnimalBreedDao;
import veterinerProject.w34.entities.concretes.AnimalBreed;

import java.util.List;

@Service
public class AnimalBreedManager implements AnimalBreedService {
    private AnimalBreedDao _animalBreedDao;

    @Autowired
    public AnimalBreedManager(AnimalBreedDao animalBreedDao) {
        _animalBreedDao = animalBreedDao;
    }

    @Override
    public Result add(AnimalBreed animalBreed) {
        _animalBreedDao.save(animalBreed);
        return new SuccessResult(animalBreed.getBreedName() + " has been added");
    }

    @Override
    public Result update(AnimalBreed animalBreed) {
        _animalBreedDao.save(animalBreed);
        return new SuccessResult(animalBreed.getBreedName() + " has been edited");
    }

    @Override
    public Result delete(AnimalBreed animalBreed) {
        _animalBreedDao.delete(animalBreed);
        return new SuccessResult(animalBreed.getBreedName() + " has been deleted");
    }

    @Override
    public DataResult<List<AnimalBreed>> getAll() {
        return new SuccessDataResult<List<AnimalBreed>>(_animalBreedDao.findAllByOrderByIdAsc());
    }

    @Override
    public DataResult<List<AnimalBreed>> getAllByTypeId(int id) {
        return new SuccessDataResult<List<AnimalBreed>>(_animalBreedDao.findAllByAnimalType_Id(id));
    }


}
