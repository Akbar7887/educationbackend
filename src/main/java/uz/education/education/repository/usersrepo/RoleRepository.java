package uz.education.education.repository.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.education.education.models.user.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
