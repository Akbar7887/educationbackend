package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.education.education.models.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date birthday;
    private String passportId;
    private String adress;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    private Date exitdate;

    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Registration> registrations = new HashSet<>();


    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;


    public Student() {
    }

    public Student(Long id, String name, Date birthday, String passportId, String adress, Date createdate, Course course, Region region, Date exitdate, Set<Registration> registrations, Active active) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.passportId = passportId;
        this.adress = adress;
        this.createdate = createdate;
        this.course = course;
        this.region = region;
        this.exitdate = exitdate;
        this.registrations = registrations;
        this.active = active;
    }

    public void addRegistration(Registration registration) {
        if (!this.registrations.contains(registration)) {
            this.registrations.add(registration);
            registration.setStudent(this);
        }
    }

    public void removeRegistration(Registration registration) {
        if (this.registrations.contains(registration)) {
            this.registrations.remove(registration);
            registration.setStudent(null);
        }
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getExitdate() {
        return exitdate;
    }

    public void setExitdate(Date exitdate) {
        this.exitdate = exitdate;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }
}
