package veterinerProject.w34.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.PhotoService;
import veterinerProject.w34.entities.concretes.Photo;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/photo/")
@PreAuthorize("hasRole('VET') or hasRole('ADMIN')")
public class PhotoController {
    private PhotoService _photoService;

    public PhotoController(PhotoService photoService) {
        _photoService = photoService;
    }

    @GetMapping("getById")
    public ResponseEntity<?> getById(int id){
        return ResponseEntity.ok(_photoService.getById(id));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestParam(value = "photoId") int photoId, @Valid @RequestParam(value = "imageFile") MultipartFile photoFile) {
        return ResponseEntity.ok(_photoService.update(photoId,photoFile));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody Photo photo) {
        return ResponseEntity.ok(_photoService.delete(photo));
    }
}
