package veterinerProject.w34.core.security.jwt;

import veterinerProject.w34.core.security.AccessToken;
import veterinerProject.w34.core.security.SecretKey;
import veterinerProject.w34.entities.concretes.Role;

import java.util.Set;

public interface IJwtTokenHelper {
    String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles);
    boolean validateJwtToken(SecretKey secretKey, AccessToken accessToken);
    String getUsernameFromJwtToken(SecretKey secretKey,AccessToken accessToken);
}

