package uz.education.education.repository.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.education.education.models.user.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
