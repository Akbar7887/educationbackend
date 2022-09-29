package uz.education.education.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {


}
