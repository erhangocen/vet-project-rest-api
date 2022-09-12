package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.AnimalOwnerService;
import veterinerProject.w34.entities.concretes.AnimalOwner;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/animalOwner/")
@CrossOrigin
@PreAuthorize("hasRole('VET') or hasRole('ADMIN')")
public class AnimalOwnerController {
    private AnimalOwnerService _animalOwnerService;

    @Autowired
    public AnimalOwnerController(AnimalOwnerService animalOwnerService) {
        _animalOwnerService = animalOwnerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_animalOwnerService.getAll());
    }

    @GetMapping("getAllPageable")
    public ResponseEntity<?> getAllPageable(int pageNo, int pageSize){
        return ResponseEntity.ok(_animalOwnerService.getAll(pageNo,pageSize));
    }

    @GetMapping("getById")
    public ResponseEntity<?> getById(@RequestParam int id){
        return ResponseEntity.ok(_animalOwnerService.getById(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody AnimalOwner animalOwner){
        return ResponseEntity.ok(_animalOwnerService.add(animalOwner));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody AnimalOwner animalOwner){
        return ResponseEntity.ok(_animalOwnerService.update(animalOwner));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody AnimalOwner animalOwner){
        return ResponseEntity.ok(_animalOwnerService.delete(animalOwner));
    }

    @PostMapping("updatePhoto")
    public ResponseEntity<?> updatePhoto(@Valid @RequestParam(value = "ownerId") int ownerId, @Valid @RequestParam(value = "imageFile") MultipartFile photoFile){
        return ResponseEntity.ok(_animalOwnerService.updatePhoto(ownerId,photoFile));
    }
}
