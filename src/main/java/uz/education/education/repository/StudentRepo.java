package uz.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.education.education.models.Active;
import uz.education.education.models.Student;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.active =:active")
    List<Student> findAll(@Param("active") Active active);
}
