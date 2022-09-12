package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.AnimalTypeService;
import veterinerProject.w34.bussiness.abstracts.PhotoService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.AnimalTypeDao;
import veterinerProject.w34.entities.concretes.AnimalType;
import veterinerProject.w34.entities.concretes.Photo;

import java.util.List;

@Service
public class AnimalTypeManager implements AnimalTypeService {

    private AnimalTypeDao _animalTypeDao;
    private PhotoService _photoService;

    @Autowired
    public AnimalTypeManager(AnimalTypeDao animalTypeDao, PhotoService photoService) {
        _animalTypeDao = animalTypeDao;
        _photoService = photoService;
    }

    @Override
    public Result add(AnimalType animalType) {

        Photo photo = new Photo();
        photo.setPhotoUrl("https://res.cloudinary.com/dbzf16o0x/image/upload/v1662249469/istockphoto-1272744666-612x612_lgek5l.jpg");
        _photoService.add(photo);

        animalType.setPhoto(photo);
        _animalTypeDao.save(animalType);
        return new SuccessResult(animalType.getTypeName() + " has been added");
    }

    @Override
    public Result update(AnimalType animalType) {
        AnimalType animalType1 = _animalTypeDao.findById(animalType.getId());
        animalType1.setTypeName(animalType.getTypeName());
        _animalTypeDao.save(animalType1);
        return new SuccessResult(animalType.getTypeName() + " has been edited");
    }

    @Override
    public Result delete(AnimalType animalType) {
        _photoService.delete(animalType.getPhoto());
        _animalTypeDao.delete(animalType);
        return new SuccessResult(animalType.getTypeName() + " has been deleted");
    }

    @Override
    public Result updatePhoto(int animalTypeId, MultipartFile multipartFile) {
        AnimalType animalType = _animalTypeDao.findById(animalTypeId);
        _photoService.update(animalType.getPhoto().getPhotoId(),multipartFile);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<AnimalType>> getAll() {
        return new SuccessDataResult<List<AnimalType>>(_animalTypeDao.findAllByOrderByIdAsc());
    }
}
