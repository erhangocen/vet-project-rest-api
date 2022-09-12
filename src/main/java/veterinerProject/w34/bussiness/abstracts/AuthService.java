package veterinerProject.w34.bussiness.abstracts;

import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.security.AccessToken;
import veterinerProject.w34.entities.dtos.LoginDto;

public interface AuthService {
    DataResult<AccessToken> login(LoginDto loginDto);
}
