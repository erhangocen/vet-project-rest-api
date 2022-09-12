package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.AnimalOwnerService;
import veterinerProject.w34.bussiness.abstracts.PhotoService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.AnimalOwnerDao;
import veterinerProject.w34.entities.concretes.AnimalOwner;
import veterinerProject.w34.entities.concretes.Photo;

import java.util.List;

@Service
public class AnimalOwnerManager implements AnimalOwnerService {

    private AnimalOwnerDao _animalOwnerDao;
    private PhotoService _photoService;

    @Autowired
    public AnimalOwnerManager(AnimalOwnerDao animalOwnerDao, PhotoService photoService) {
        _animalOwnerDao = animalOwnerDao;
        _photoService = photoService;
    }

    @Override
    public Result add(AnimalOwner animalOwner) {

        Photo photo = new Photo();
        photo.setPhotoUrl("https://res.cloudinary.com/dbzf16o0x/image/upload/v1657832793/Ec6ferCXYAA6XB__ednbzx.jpg");
        _photoService.add(photo);

        animalOwner.setPhoto(photo);

        _animalOwnerDao.save(animalOwner);
        return new SuccessResult(animalOwner.getFirstName() + " has been added");
    }

    @Override
    public Result update(AnimalOwner animalOwner) {

        AnimalOwner animalOwner1 = _animalOwnerDao.findById(animalOwner.getId());
        animalOwner1.setFirstName(animalOwner.getFirstName());
        animalOwner1.setLastName(animalOwner.getLastName());
        animalOwner1.setEmail(animalOwner.getEmail());
        animalOwner1.setPhoneNumber(animalOwner.getPhoneNumber());

        _animalOwnerDao.save(animalOwner1);
        return new SuccessResult(animalOwner.getFirstName() + " has been edited");
    }

    @Override
    public Result delete(AnimalOwner animalOwner) {
        _photoService.delete(animalOwner.getPhoto());
        _animalOwnerDao.delete(animalOwner);
        return new SuccessResult(animalOwner.getFirstName() + " has been deleted");
    }

    @Override
    public Result updatePhoto(int ownerId, MultipartFile multipartFile) {
        AnimalOwner animalOwner = _animalOwnerDao.getById(ownerId);
        _photoService.update(animalOwner.getPhoto().getPhotoId(), multipartFile);
        return new SuccessResult(animalOwner.getFirstName() + "'s photo has been updated");
    }

    @Override
    public DataResult<List<AnimalOwner>> getAll() {
        return new SuccessDataResult<List<AnimalOwner>>(_animalOwnerDao.findAllByOrderByIdDesc());
    }

    @Override
    public DataResult<List<AnimalOwner>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<AnimalOwner>>(_animalOwnerDao.findAllByOrderByIdDesc(pageable));
    }

    @Override
    public DataResult<AnimalOwner> getById(int id) {
        return new SuccessDataResult<AnimalOwner>(_animalOwnerDao.findById(id));
    }
}
