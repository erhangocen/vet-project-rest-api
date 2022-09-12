package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import veterinerProject.w34.bussiness.abstracts.AnimalBreedService;
import veterinerProject.w34.entities.concretes.AnimalBreed;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/animalBreed/")
@PreAuthorize("hasRole('VET') or hasRole('ADMIN')")
@CrossOrigin
public class AnimalBreedController {
    private AnimalBreedService _animalBreedService;

    @Autowired
    public AnimalBreedController(AnimalBreedService animalBreedService) {
        _animalBreedService = animalBreedService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_animalBreedService.getAll());
    }

    @GetMapping("getByTypeId")
    public ResponseEntity<?> getByTypeId(int id){
        return ResponseEntity.ok(_animalBreedService.getAllByTypeId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody AnimalBreed animalBreed){
        return ResponseEntity.ok(_animalBreedService.add(animalBreed));
    }

    @PostMapping("update")
        public ResponseEntity<?> update(@RequestBody AnimalBreed animalBreed){
            return ResponseEntity.ok(_animalBreedService.update(animalBreed));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody AnimalBreed animalBreed){
        return ResponseEntity.ok(_animalBreedService.delete(animalBreed));
    }
}
