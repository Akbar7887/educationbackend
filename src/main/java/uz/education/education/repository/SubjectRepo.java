package uz.education.education.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Subject;

import java.util.List;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Long> {
    List<Subject> findAll();
}
