package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.PhotoService;
import veterinerProject.w34.bussiness.abstracts.AnimalService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.AnimalDao;
import veterinerProject.w34.entities.concretes.Animal;
import veterinerProject.w34.entities.concretes.Photo;

import java.util.List;

@Service
public class AnimalManager implements AnimalService {

    private AnimalDao _animalDao;
    private PhotoService _photoService;

    @Autowired
    public AnimalManager(AnimalDao animalDao, PhotoService photoService) {
        _animalDao = animalDao;
        _photoService = photoService;
    }

    @Override
    public Result add(Animal animal) {

        Photo animalPhoto = new Photo();
        _photoService.add(animalPhoto);

        animal.setPhoto(animalPhoto);
        _animalDao.save(animal);
        return new SuccessResult(animal.getName() + " has been added");
    }

    @Override
    public Result update(Animal animal) {

        Animal animal1 = _animalDao.findById(animal.getId());

        animal1.setAge(animal.getAge());
        animal1.setName(animal.getName());
        animal1.setDescription(animal.getDescription());
        animal1.setAnimalBreed(animal.getAnimalBreed());
        animal1.setAnimalOwner(animal.getAnimalOwner());

        _animalDao.save(animal1);
        return new SuccessResult(animal.getName() + " has been edited");
    }

    @Override
    public Result delete(Animal animal) {
        _photoService.delete(animal.getPhoto());
        _animalDao.delete(animal);
        return new SuccessResult(animal.getName() + " has been deleted");
    }

    @Override
    public Result updatePhoto(int animalId, MultipartFile multipartFile) {
        Animal animal = _animalDao.findById(animalId);
        _photoService.update(animal.getPhoto().getPhotoId(),multipartFile);
        return new SuccessResult(animal.getName() + "'s photo has been updated");
    }

    @Override
    public DataResult<List<Animal>> getAllByTypeId(int id, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByAnimalBreed_AnimalType_Id(id,pageable));
    }

    @Override
    public DataResult<List<Animal>> getAllByBreedId(int id, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByAnimalBreed_Id(id,pageable));
    }

    @Override
    public DataResult<List<Animal>> getAllByTypeId(int id) {
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByAnimalBreed_AnimalType_Id(id));
    }

    @Override
    public DataResult<List<Animal>> getAllByBreedId(int id) {
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByAnimalBreed_Id(id));
    }

    @Override
    public DataResult<List<Animal>> getAllByOwnerId(int id) {
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByAnimalOwner_Id(id));
    }

    @Override
    public DataResult<List<Animal>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByOrderByIdDesc(pageable));
    }

    @Override
    public DataResult<List<Animal>> getAll() {
        return new SuccessDataResult<List<Animal>>(_animalDao.findAllByOrderByIdDesc());
    }

}
