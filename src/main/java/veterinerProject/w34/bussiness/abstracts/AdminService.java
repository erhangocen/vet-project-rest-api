package veterinerProject.w34.bussiness.abstracts;

import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.Admin;
import veterinerProject.w34.entities.concretes.UserRole;

import java.util.List;

public interface AdminService {
    Result add(Admin admin);
    Result update(Admin admin);
    DataResult<List<Admin>> getAll();
}
