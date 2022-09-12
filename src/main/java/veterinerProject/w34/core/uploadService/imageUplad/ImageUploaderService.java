package veterinerProject.w34.core.uploadService.imageUplad;

import java.io.IOException;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.core.results.DataResult;

public interface ImageUploaderService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
