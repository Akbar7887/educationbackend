package uz.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Active;
import uz.education.education.models.Level;

import java.util.List;

@Repository
public interface LevelRepo extends JpaRepository<Level, Long> {

    @Query("select l from level l where l.course.id =:course_id and l.subject.id=:subject_id and l.active=:active")
    public List<Level> getAllActiveCourseSubject(@Param("course_id") Long course_id,
                                    @Param("subject_id") Long subject_id,
                                    @Param("active") Active active);
}
