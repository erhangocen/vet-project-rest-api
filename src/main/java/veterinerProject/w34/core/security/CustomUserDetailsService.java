package veterinerProject.w34.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import veterinerProject.w34.dataAccess.abstracts.RoleDao;
import veterinerProject.w34.dataAccess.abstracts.UserDao;
import veterinerProject.w34.entities.concretes.Role;
import veterinerProject.w34.entities.concretes.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);

        if (user == null) {
            new UsernameNotFoundException("User not found with username : " + username);
        }

        Set<Role> roles = user.getRoles();

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(getSimpleGrantedAuthorities(roles))
                .accountExpired(false)
                .accountLocked(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();



    }
    private Set<GrantedAuthority> getSimpleGrantedAuthorities(Set<Role> roles){
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return grantedAuthorities;
    }
}
