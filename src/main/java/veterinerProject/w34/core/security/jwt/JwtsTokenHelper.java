package veterinerProject.w34.core.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import veterinerProject.w34.core.security.AccessToken;
import veterinerProject.w34.core.security.SecretKey;
import veterinerProject.w34.entities.concretes.Role;
import veterinerProject.w34.exceptions.security.CustomSecurityException;

import java.util.Base64;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtsTokenHelper implements IJwtTokenHelper {
    @Override
    public String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("authorities",roles.stream().map(role -> {
            return new SimpleGrantedAuthority(role.getRoleName());
        }).collect(Collectors.toList()));


        Date issuedAt = new Date();
        Date validUntil = new Date(issuedAt.getTime() + secretKey.getExpirationInMiliseconds());
        String secretKeyEncoded  = Base64.getEncoder().encodeToString(secretKey.getSecretKey().getBytes());
        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(issuedAt)
                .setExpiration(validUntil)
                .signWith(SignatureAlgorithm.HS256,secretKeyEncoded)
                .compact();
    }

    @Override
    public boolean validateJwtToken(SecretKey secretKey, AccessToken accessToken) {
        try {
            String secretKeyEncoded  = Base64.getEncoder().encodeToString(secretKey.getSecretKey().getBytes());
            Jwts.parser().setSigningKey(secretKeyEncoded).parseClaimsJws(accessToken.getToken());
            return true;
        }
        catch (JwtException | IllegalArgumentException exception) {
            throw new CustomSecurityException("INVALID TOKEN", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String getUsernameFromJwtToken(SecretKey secretKey, AccessToken accessToken) {
        String secretKeyEncoded  = Base64.getEncoder().encodeToString(secretKey.getSecretKey().getBytes());
        return Jwts.parser().setSigningKey(secretKeyEncoded).parseClaimsJws(accessToken.getToken()).getBody().getSubject();
    }

}
