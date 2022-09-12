package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import veterinerProject.w34.bussiness.abstracts.AnimalTypeService;
import veterinerProject.w34.entities.concretes.AnimalType;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/animalType/")
@CrossOrigin
@PreAuthorize("hasRole('VET') or hasRole('ADMIN')")
public class AnimalTypeController {
    private AnimalTypeService _animalTypeService;

    @Autowired
    public AnimalTypeController(AnimalTypeService animalTypeService) {
        _animalTypeService = animalTypeService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_animalTypeService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody AnimalType animalType){
        return ResponseEntity.ok(_animalTypeService.add(animalType));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody AnimalType animalType){
        return ResponseEntity.ok(_animalTypeService.update(animalType));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody AnimalType animalType){
        return ResponseEntity.ok(_animalTypeService.delete(animalType));
    }

    @PostMapping("updatePhoto")
    public ResponseEntity<?> updatePhoto(@Valid @RequestParam(value = "typeId") int typeId, @Valid @RequestParam(value = "imageFile") MultipartFile photoFile){
        return ResponseEntity.ok(_animalTypeService.updatePhoto(typeId,photoFile));
    }
}
