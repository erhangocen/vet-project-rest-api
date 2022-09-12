package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import veterinerProject.w34.bussiness.abstracts.VetService;
import veterinerProject.w34.entities.concretes.Vet;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vet/")
@CrossOrigin
@PreAuthorize("hasRole('ADMIN')")
public class VetController {
    private VetService _vetService;

    @Autowired
    public VetController(VetService vetService) {
        _vetService = vetService;
    }

    @GetMapping("getAll")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_vetService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Vet vet){
        return ResponseEntity.ok(_vetService.add(vet));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Vet vet){
        return ResponseEntity.ok(_vetService.update(vet));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Vet vet){
        return ResponseEntity.ok(_vetService.delete(vet));
    }

}
