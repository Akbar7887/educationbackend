package uz.education.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Active;
import uz.education.education.models.Task;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.active=:active")
    List<Task> getAllActive(@Param("active") Active active);

    @Query("select t from Task t where t.level.level_id=:id and t.active=:active")
    List<Task> findByLevelId(@Param("id") long id, @Param("active") Active active);

    @Query("select t from Task t where t.active=:active and t.show=:show")
    List<Task> findActiveShow(@Param("active") Active active, @Param("show") boolean show);



}
