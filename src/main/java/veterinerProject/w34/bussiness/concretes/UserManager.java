package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinerProject.w34.bussiness.abstracts.UserService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.UserDao;
import veterinerProject.w34.entities.concretes.Role;
import veterinerProject.w34.entities.concretes.User;
import veterinerProject.w34.entities.concretes.Vet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserManager implements UserService {

    private UserDao _userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        _userDao = userDao;
    }

    @Override
    public DataResult<User> getByUserName(String userName) {
        return new SuccessDataResult<User>(_userDao.findByUsername(userName));
    }

    @Override
    public DataResult<Set<Role>> getUserRolesByUserName(String userName) {
        return new SuccessDataResult<Set<Role>>(_userDao.findByUsername(userName).getRoles());
    }

    @Override
    public Result setDisable(int id) {
        User user = _userDao.findById(id);
        user.setEnable(false);
        _userDao.save(user);
        return new SuccessResult(user.getUsername() + "set as disable");
    }

    @Override
    public Result setEnable(int id) {
        User user = _userDao.findById(id);
        user.setEnable(true);
        _userDao.save(user);
        return new SuccessResult(user.getUsername() + "set as enable");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(_userDao.findAll());
    }
}
