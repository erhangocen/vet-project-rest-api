package veterinerProject.w34.bussiness.concretes;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import veterinerProject.w34.bussiness.abstracts.AuthService;
import veterinerProject.w34.bussiness.abstracts.UserService;
import veterinerProject.w34.core.results.*;
import veterinerProject.w34.core.security.AccessToken;
import veterinerProject.w34.core.security.ITokenProvider;
import veterinerProject.w34.dataAccess.abstracts.RoleDao;
import veterinerProject.w34.dataAccess.abstracts.UserDao;
import veterinerProject.w34.entities.concretes.Role;
import veterinerProject.w34.entities.concretes.User;
import veterinerProject.w34.entities.dtos.LoginDto;
import veterinerProject.w34.exceptions.security.CustomSecurityException;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@Transactional
public class AuthManager implements AuthService {
    @Autowired
    private ITokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public DataResult<AccessToken> login(LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        User targetUser = userService.getByUserName(username).getData();

        if (targetUser == null || targetUser.isEnable()){
            try {
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
                Set<Role> roles = userService.getUserRolesByUserName(username).getData();
                return new SuccessDataResult<AccessToken>(tokenProvider.createToken(username,roles),"Successful Login");

            }catch (AuthenticationException exception) {
                return new ErrorDataResult<AccessToken>("Incorrect Login Informations");

            }
        }
        return new ErrorDataResult<AccessToken>("User Not Found");
    }

    private Set<Role> getRoles(String [] roles){
        Set<Role> userRoles = new HashSet<>();
        for(String role : roles) {
            userRoles.add(roleDao.findByRoleName(role));
        }
        return userRoles;
    }

}
