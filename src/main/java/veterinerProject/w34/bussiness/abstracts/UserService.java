package veterinerProject.w34.bussiness.abstracts;

import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.Role;
import veterinerProject.w34.entities.concretes.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    DataResult<User> getByUserName(String userName);
    DataResult<Set<Role>> getUserRolesByUserName(String userName);
    Result setDisable(int id);
    Result setEnable(int id);
    DataResult<List<User>> getAll();
}
