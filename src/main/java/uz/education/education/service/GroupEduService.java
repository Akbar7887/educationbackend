package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Active;
import uz.education.education.models.Course;
import uz.education.education.models.GroupEdu;
import uz.education.education.models.Student;
import uz.education.education.repository.CourseRepo;
import uz.education.education.repository.GroupEduRepo;
import uz.education.education.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupEduService {

    private final GroupEduRepo groupEduRepo;
    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;

    public GroupEdu save(GroupEdu groupEdu, String id) {
        Optional<Course> courseOptional = courseRepo.findById(Long.parseLong(id));

        if (courseOptional.isPresent()) {
//            groupEdu.setCourse(courseOptional.get());
            GroupEdu groupEdu1 = groupEduRepo.save(groupEdu);
            Course course = courseOptional.get();
            course.addGroup(groupEdu1);
            courseRepo.save(course);

            return groupEdu1;
        } else {
            return null;
        }
    }

    public GroupEdu addStudent(String group_id, String student_id) {
        Optional<GroupEdu> groupEduOptional = groupEduRepo.findById(Long.parseLong(group_id));
        Optional<Student> studentOptional = studentRepo.findById(Long.parseLong(student_id));
        if (!groupEduOptional.isPresent()
                || !studentOptional.isPresent()) {
            return null;
        }

        GroupEdu groupEdu = groupEduOptional.get();
        Student student = studentOptional.get();
        groupEdu.getStudents().add(student);

        return groupEduRepo.save(groupEdu);

    }

    public List<GroupEdu> getAllActive() {
        return groupEduRepo.getAllActive(Active.ACTIVE);
    }

    public GroupEdu remove(String id) {
        GroupEdu groupEdu = groupEduRepo.getById(Long.parseLong(id));
        groupEdu.setActive(Active.NOACTIVE);
        Optional<Course> courseOptional = courseRepo.findById(groupEdu.getId());
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.removeGroup(groupEdu);
            courseRepo.save(course);
        }

        return groupEduRepo.save(groupEdu);
    }

    public GroupEdu getOne(String id) {

        Optional<GroupEdu> groupEduOptional = groupEduRepo.findById(Long.parseLong(id));
        if (groupEduOptional.isPresent()) {
            GroupEdu groupEdu = groupEduOptional.get();
            return groupEduRepo.save(groupEdu);
        } else {
            return null;
        }
    }

    public GroupEdu removeStudent(String group_id, String student_id) {
        Optional<GroupEdu> groupEduOptional = groupEduRepo.findById(Long.parseLong(group_id));
        Optional<Student> studentOptional = studentRepo.findById(Long.parseLong(student_id));
        if (!groupEduOptional.isPresent()
                || !studentOptional.isPresent()) {
            return null;
        }

        GroupEdu groupEdu = groupEduOptional.get();
        Student student = studentOptional.get();
        if (groupEdu.getStudents().contains(student)) {
            groupEdu.getStudents().remove(student);
        }

        return groupEduRepo.save(groupEdu);

    }
}
