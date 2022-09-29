package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
public class GroupEdu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "course_id_fk"))
    @JsonBackReference
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdate;

    @OneToMany(mappedBy = "groupEdu",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Registration> registrations = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;


    public void addRegistration(Registration registration) {
        if (!this.registrations.contains(registration)) {
            this.registrations.add(registration);
            registration.setGroupEdu(this);
        }
    }

    public void removeRegistration(Registration registration) {
        if (this.registrations.contains(registration)) {
            this.registrations.remove(registration);
            registration.setGroupEdu(null);
        }
    }

    public GroupEdu() {
    }

    public GroupEdu(Long id, String name, Course course, Subject subject, Date createdate, List<Registration> registrations, Active active) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.subject = subject;
        this.createdate = createdate;
        this.registrations = registrations;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupEdu)) return false;
        GroupEdu groupEdu = (GroupEdu) o;
        return Objects.equals(getId(), groupEdu.getId()) && Objects.equals(getName(), groupEdu.getName()) && Objects.equals(getCourse(), groupEdu.getCourse()) && Objects.equals(getSubject(), groupEdu.getSubject()) && Objects.equals(getCreatedate(), groupEdu.getCreatedate()) && Objects.equals(getRegistrations(), groupEdu.getRegistrations()) && getActive() == groupEdu.getActive();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCourse(), getSubject(), getCreatedate(), getRegistrations(), getActive());
    }
}
