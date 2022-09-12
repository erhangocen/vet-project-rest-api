package veterinerProject.w34.bussiness.abstracts;

import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.Photo;

public interface PhotoService {
    Result add(Photo photo);
    Result update(int id, MultipartFile multipartFile);
    Result delete(Photo photo);

    DataResult<Photo> getById(int id);
}
