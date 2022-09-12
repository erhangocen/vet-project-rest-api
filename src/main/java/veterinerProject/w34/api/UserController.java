package veterinerProject.w34.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinerProject.w34.bussiness.abstracts.UserService;
import veterinerProject.w34.entities.concretes.User;
import veterinerProject.w34.entities.concretes.Vet;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private UserService _userService;

    @Autowired
    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping("getUserRolesByUserName")
    public ResponseEntity<?> getUserRolesByUserName(@RequestParam String userName){
        return ResponseEntity.ok(_userService.getUserRolesByUserName(userName));
    }

    @GetMapping("getByUserName")
    public ResponseEntity<?> getByUserName(@RequestParam String userName){
        return ResponseEntity.ok(_userService.getByUserName(userName));
    }

    @PostMapping("disable")
    public ResponseEntity<?> setDisable(@RequestParam int userId){
        return ResponseEntity.ok(_userService.setDisable(userId));
    }

    @PostMapping("enable")
    public ResponseEntity<?> setEnable(@RequestParam int userId){
        return ResponseEntity.ok(_userService.setEnable(userId));
    }
}
