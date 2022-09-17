package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class GroupEdu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "course_id_fk"))
    @JsonBackReference
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;

    public GroupEdu() {
    }

    public GroupEdu(Long id, String name, Course course, Subject subject, Active active) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupEdu)) return false;
        GroupEdu groupEdu = (GroupEdu) o;
        return Objects.equals(getId(), groupEdu.getId()) && Objects.equals(getName(), groupEdu.getName()) && Objects.equals(getCourse(), groupEdu.getCourse()) && Objects.equals(getSubject(), groupEdu.getSubject()) && getActive() == groupEdu.getActive();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCourse(), getSubject(), getActive());
    }

    @Override
    public String toString() {
        return "GroupEdu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", subject=" + subject +
                ", active=" + active +
                '}';
    }
}
