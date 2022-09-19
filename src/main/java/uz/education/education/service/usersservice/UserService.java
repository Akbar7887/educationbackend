package uz.education.education.service.usersservice;

import uz.education.education.models.user.AppUser;
import uz.education.education.models.user.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    AppUser getUser(String username);

    List<AppUser> getUser();


}
