package veterinerProject.w34.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginDto {
    private String username;
    private String password;
}
