package veterinerProject.w34.core.security;

import org.springframework.security.core.Authentication;
import veterinerProject.w34.entities.concretes.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface ITokenProvider {


    AccessToken createToken(String username, Set<Role> roles);
    boolean validateToken(AccessToken accessToken);
    AccessToken getTokenFromHeader(HttpServletRequest httpServletRequest);
    Authentication getAuthentication(AccessToken accessToken);
}