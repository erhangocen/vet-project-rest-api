package veterinerProject.w34.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinerProject.w34.bussiness.abstracts.AuthService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.security.AccessToken;
import veterinerProject.w34.dataAccess.abstracts.UserDao;
import veterinerProject.w34.entities.dtos.LoginDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserDao userDao;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        DataResult<AccessToken> accessToken = authService.login(loginDto);
        return ResponseEntity.ok(accessToken);
    }
}
