package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.AnimalService;
import veterinerProject.w34.entities.concretes.Animal;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/animal/")
@CrossOrigin
@PreAuthorize("hasRole('VET') or hasRole('ADMIN')")
public class AnimalController {
    private AnimalService _animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        _animalService = animalService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_animalService.getAll());
    }

    @GetMapping("getAllPageable")
    public ResponseEntity<?> getAllPageable(int pageNo, int pageSize){
        return ResponseEntity.ok(_animalService.getAll(pageNo, pageSize));
    }

    @GetMapping("getAllByTypeIdPageable")
    public ResponseEntity<?> getAllByTypeIdPageable(int id, int pageNo, int pageSize){
        return ResponseEntity.ok(_animalService.getAllByTypeId(id,pageNo,pageSize));
    }

    @GetMapping("getAllByBreedIdPageable")
    public ResponseEntity<?> getAllByBreedIdPageable(int id, int pageNo, int pageSize){
        return ResponseEntity.ok(_animalService.getAllByBreedId(id,pageNo, pageSize));
    }

    @GetMapping("getAllByTypeId")
    public ResponseEntity<?> getAllByTypeId(int id){
        return ResponseEntity.ok(_animalService.getAllByTypeId(id));
    }

    @GetMapping("getAllByBreedId")
    public ResponseEntity<?> getAllByBreedId(int id){
        return ResponseEntity.ok(_animalService.getAllByBreedId(id));
    }

    @GetMapping("getAllByOwnerId")
    public ResponseEntity<?> getAllByOwnerId(int id){
        return ResponseEntity.ok(_animalService.getAllByOwnerId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Animal animal){
        return ResponseEntity.ok(_animalService.add(animal));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Animal animal){
        return ResponseEntity.ok(_animalService.update(animal));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody Animal animal){
        return ResponseEntity.ok(_animalService.delete(animal));
    }

    @PostMapping("updatePhoto")
    public ResponseEntity<?> updatePhoto(@Valid @RequestParam(value = "animalId") int animalId, @Valid @RequestParam(value = "imageFile") MultipartFile photoFile){
        return ResponseEntity.ok(_animalService.updatePhoto(animalId,photoFile));
    }
}
