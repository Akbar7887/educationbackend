package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Active;
import uz.education.education.models.Course;
import uz.education.education.models.Level;
import uz.education.education.models.Subject;
import uz.education.education.repository.CourseRepo;
import uz.education.education.repository.LevelRepo;
import uz.education.education.repository.SubjectRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LevelService {


    final LevelRepo levelRepo;
    final CourseRepo courseRepo;
    final SubjectRepo subjectRepo;


    public List<Level> getAllActiveCourseSubject(String course_id, String subject_id) {
        return levelRepo.getAllActiveCourseSubject(Long.parseLong(course_id), Long.parseLong(subject_id), Active.ACTIVE);
    }

    public Level save(Level level){
        return levelRepo.save(level);
    }

    public Level remove(String id){

        Optional<Level> levelOptional = levelRepo.findById(Long.parseLong(id));
        if(!levelOptional.isPresent()){
            return null;
        }
        Level level = levelOptional.get();
        level.setActive(Active.NOACTIVE);
        return levelRepo.save(level);
    }

}
