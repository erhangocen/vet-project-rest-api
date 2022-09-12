package veterinerProject.w34.core.security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretKey {
    private String secretKey;
    private long expirationInMiliseconds;
}
