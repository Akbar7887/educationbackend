package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "level")
@Table(name = "level")

public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long level_id;

    private String levelname;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "subject_id_fx"))
    private Subject subject;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> taskList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;

    public Level() {
    }

    public Level(Long level_id, String levelname, String description, Course course, Subject subject, List<Task> taskList, Active active) {
        this.level_id = level_id;
        this.levelname = levelname;
        this.description = description;
        this.course = course;
        this.subject = subject;
        this.taskList = taskList;
        this.active = active;
    }

    public void addTask(Task task) {
        if (!this.taskList.contains(task)) {
            this.taskList.add(task);
            task.setLevel(this);
        }
    }

    public void removeTask(Task task) {
        if (this.taskList.contains(task)) {
            this.taskList.remove(task);
            task.setLevel(null);
        }
    }


    public Long getLevel_id() {
        return level_id;
    }

    public void setLevel_id(Long level_id) {
        this.level_id = level_id;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
