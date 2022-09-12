package veterinerProject.w34.bussiness.abstracts;

import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.UserRole;

import java.util.List;

public interface UserRoleService {
    Result add(UserRole userRole);
    Result update(UserRole userRole);
    Result delete(UserRole userRole);

    DataResult<List<UserRole>> getAll();
}
