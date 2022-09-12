package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import veterinerProject.w34.bussiness.abstracts.UserRoleService;
import veterinerProject.w34.entities.concretes.AnimalBreed;
import veterinerProject.w34.entities.concretes.UserRole;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/userRole/")
@PreAuthorize("hasRole('ADMIN')")
public class UserRoleController {
    private UserRoleService _userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        _userRoleService = userRoleService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_userRoleService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody UserRole userRole){
        return ResponseEntity.ok(_userRoleService.add(userRole));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody UserRole userRole){
        return ResponseEntity.ok(_userRoleService.update(userRole));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody UserRole userRole){
        return ResponseEntity.ok(_userRoleService.delete(userRole));
    }
}
