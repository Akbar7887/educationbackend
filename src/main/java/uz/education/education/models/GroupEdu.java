package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class GroupEdu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="course_id_fk"))
    @JsonBackReference
    private Course course;

    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;

    public GroupEdu() {
    }

    public GroupEdu(Long id, String name, Course course, Active active) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }
}
