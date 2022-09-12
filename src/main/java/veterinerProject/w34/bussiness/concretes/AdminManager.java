package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import veterinerProject.w34.bussiness.abstracts.AdminService;
import veterinerProject.w34.bussiness.abstracts.UserRoleService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.AdminDao;
import veterinerProject.w34.entities.concretes.Admin;
import veterinerProject.w34.entities.concretes.UserRole;

import java.util.List;

@Service
public class AdminManager implements AdminService {

    private AdminDao _adminDao;
    private UserRoleService _userRoleService;

    @Autowired
    public AdminManager(AdminDao adminDao, UserRoleService userRoleService) {
        _adminDao = adminDao;
        _userRoleService = userRoleService;
    }

    @Override
    public Result add(Admin admin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        _adminDao.save(admin);

        UserRole userRole = new UserRole();
        userRole.setRoleId(1); //1 => ROLE_ADMİN
        userRole.setUserId(admin.getId());
        _userRoleService.add(userRole);
        return new SuccessResult();
    }

    @Override
    public Result update(Admin admin) {
        _adminDao.save(admin);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Admin>> getAll() {
        return new SuccessDataResult<List<Admin>>(_adminDao.findAll());
    }
}
