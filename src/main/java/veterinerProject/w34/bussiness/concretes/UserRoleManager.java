package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinerProject.w34.bussiness.abstracts.UserRoleService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.UserRoleDao;
import veterinerProject.w34.entities.concretes.UserRole;

import java.util.List;

@Service
public class UserRoleManager implements UserRoleService {

    private UserRoleDao _userRoleDao;

    @Autowired
    public UserRoleManager(UserRoleDao userRoleDao) {
        _userRoleDao = userRoleDao;
    }

    @Override
    public Result add(UserRole userRole) {
        _userRoleDao.save(userRole);
        return new SuccessResult();
    }

    @Override
    public Result update(UserRole userRole) {
        _userRoleDao.save(userRole);
        return new SuccessResult();
    }

    @Override
    public Result delete(UserRole userRole) {
        _userRoleDao.delete(userRole);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<UserRole>> getAll() {
        return new SuccessDataResult<List<UserRole>>(_userRoleDao.findAll());
    }
}
