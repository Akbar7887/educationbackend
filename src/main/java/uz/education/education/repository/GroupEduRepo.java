package uz.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Active;
import uz.education.education.models.GroupEdu;

import java.util.List;

@Repository
public interface GroupEduRepo extends JpaRepository<GroupEdu, Long> {

    @Query("select g from GroupEdu g where g.active=:active")
    List<GroupEdu> getAllActive(@Param("active") Active active);

    GroupEdu getById(Long id);

}
