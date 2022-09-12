package veterinerProject.w34.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import veterinerProject.w34.bussiness.abstracts.UserRoleService;
import veterinerProject.w34.bussiness.abstracts.VetService;
import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.core.results.SuccessDataResult;
import veterinerProject.w34.core.results.SuccessResult;
import veterinerProject.w34.dataAccess.abstracts.VetDao;
import veterinerProject.w34.entities.concretes.UserRole;
import veterinerProject.w34.entities.concretes.Vet;

import java.util.List;

@Service
public class VetManager implements VetService {

    private VetDao _vetDao;
    private UserRoleService _userRoleService;

    @Autowired
    public VetManager(VetDao vetDao, UserRoleService userRoleService) {
        _vetDao = vetDao;
        _userRoleService = userRoleService;
    }

    @Override
    public Result add(Vet vet) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        vet.setPassword(passwordEncoder.encode(vet.getPassword()));
        _vetDao.save(vet);

        UserRole userRole = new UserRole();
        userRole.setRoleId(2);  // 2 => ROLE_VET
        userRole.setUserId(vet.getId());
        _userRoleService.add(userRole);
        return new SuccessResult(vet.getUsername() + " has been added");
    }

    @Override
    public Result update(Vet vet) {
        _vetDao.save(vet);
        return new SuccessResult(vet.getUsername() + " has been edited");
    }

    @Override
    public Result delete(Vet vet) {
        _vetDao.delete(vet);
        return new SuccessResult(vet.getUsername() + " has been deleted");
    }

    @Override
    public DataResult<List<Vet>> getAll() {
        return new SuccessDataResult<List<Vet>>(_vetDao.findAllByOrderByIdAsc());
    }
}
