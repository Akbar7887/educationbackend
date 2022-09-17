package uz.education.education;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uz.education.education.models.Course;
import uz.education.education.models.Region;
import uz.education.education.repository.CourseRepo;
import uz.education.education.repository.RegionRepo;
import uz.education.education.service.RegionService;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class EducationApplicationTests {

    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private CourseRepo courseRepo;


    @Test
    public void contextLoads() throws Exception {

       // crat_region();
      //  create_course()
    }

    @Test
    void crat_region() {
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
    void create_course() {

        for (int i = 1; i <= 10; i++) {
            Course course = new Course();
            course.setLevel(String.valueOf(i));
            courseRepo.save(course);
        }
    }
}
