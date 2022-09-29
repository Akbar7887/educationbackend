package uz.education.education;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uz.education.education.models.*;
import uz.education.education.models.Student;
import uz.education.education.repository.*;

import java.util.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class EducationApplicationTests {

    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private GroupEduRepo groupEduRepo;
    @Autowired
    private LevelRepo levelRepo;


    @Test
    public void contextLoads() throws Exception {

        // crat_region();
        //  create_course()
    }

    @Test
    void crat_region() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Тошкент ш.");
        list.add("Қорақалпоғистон\n" +
                "Республикаси");
        list.add("Андижон вилояти");
        list.add("Бухоро вилояти");
        list.add("Жиззах вилояти");
        list.add("Қашқадарё вилояти");
        list.add("Навоий вилояти");
        list.add("Наманган вилояти");
        list.add("Самарқанд вилояти");
        list.add("Сурхондарё вилояти");
        list.add("Сирдарё вилояти");
        list.add("Тошкент вилояти");
        list.add("Фарғона вилояти");
        list.add("Хоразм вилояти");

        for (String str : list) {
            Region region = new Region();
            region.setName(str);
            regionRepo.save(region);
        }


    }

    @Test
    void create_course() throws Exception {

        for (int i = 1; i <= 10; i++) {
            Course course = new Course();
            course.setLevel(String.valueOf(i));
            courseRepo.save(course);
        }
    }

    @Test
    void create_subject() throws Exception {
        String[] sub = new String[8];
        sub[0] = "Физика";
        sub[1] = "Рус тили";
        sub[2] = "Тарих";
        sub[3] = "Информатика";
        sub[4] = "Биология";

        for (String st : sub) {
            Subject subject = new Subject();
            subject.setName(st);
            subjectRepo.save(subject);
        }

    }


    @Test
    void createstudent() throws Exception {

//        GroupEdu groupEdu = groupEduRepo.findById(1L).get();
//        GroupEdu groupEdu1 = groupEduRepo.findById(2L).get();
//
//        groupEdu.setRegistrations(null);
//        groupEduRepo.save(groupEdu);
//
//
//        groupEdu1.setRegistrations(null);
//        groupEduRepo.save(groupEdu1);


        Student student = studentRepo.findById(17L).get();

//        student.setRegistrations(null);
//        studentRepo.save(student);


        GroupEdu groupEdu = groupEduRepo.findById(2L).get();
//         GroupEdu groupEdu1 = groupEduRepo.findById(2L).get();

        Registration registration = new Registration();
        registration.setGroupEdu(groupEdu);
        registration.setStudent(student);

        student.addRegistration(registration);

        groupEdu.addRegistration(registration);

        studentRepo.save(student);

    }

    @Test
    void clearLevelFromTask() throws Exception {

        List<Level> levels = levelRepo.findAll();

        for (Level level : levels) {

            level.setTaskList(new ArrayList<>());
            levelRepo.save(level);
        }


    }


}
