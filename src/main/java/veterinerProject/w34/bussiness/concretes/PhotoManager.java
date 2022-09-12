package veterinerProject.w34.bussiness.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.PhotoService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.core.uploadService.imageUplad.ImageUploaderService;
import veterinerProject.w34.dataAccess.abstracts.PhotoDao;
import veterinerProject.w34.entities.concretes.Photo;

import java.util.Map;

@Service
public class PhotoManager implements PhotoService {

    private PhotoDao _photoDao;
    private ImageUploaderService _imageUploaderService;

    public PhotoManager(PhotoDao animalPhotoDao, ImageUploaderService imageUploaderService) {
        _photoDao = animalPhotoDao;
        _imageUploaderService = imageUploaderService;
    }

    @Override
    public Result add(Photo photo) {
        _photoDao.save(photo);
        return new SuccessResult();
    }

    @Override
    public Result update(int id, MultipartFile multipartFile) {
        Map<String,String> uploadImage = _imageUploaderService.uploadImageFile(multipartFile).getData();
        Photo photo = _photoDao.findByPhotoId(id);
        photo.setPhotoUrl(uploadImage.get("url"));
        _photoDao.save(photo);
        return new SuccessResult();
    }

    @Override
    public Result delete(Photo photo) {
        _photoDao.delete(photo);
        return new SuccessResult();
    }

    @Override
    public DataResult<Photo> getById(int id) {
        return new SuccessDataResult<Photo>(_photoDao.findByPhotoId(id));
    }
}
