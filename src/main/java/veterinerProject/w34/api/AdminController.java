package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import veterinerProject.w34.bussiness.abstracts.AdminService;
import veterinerProject.w34.entities.concretes.Admin;
import veterinerProject.w34.entities.concretes.AnimalBreed;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private AdminService _adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        _adminService = adminService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_adminService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Admin admin){
        return ResponseEntity.ok(_adminService.add(admin));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Admin admin){
        return ResponseEntity.ok(_adminService.update(admin));
    }

}
