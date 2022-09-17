package uz.education.education.models.user;

import org.hibernate.annotations.CreationTimestamp;
import uz.education.education.models.Active;
import uz.education.education.models.Course;
import uz.education.education.models.GroupEdu;
import uz.education.education.models.Subject;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private  String lastname;
    private Date birthday;
    private  String passportId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    Date exitdate;

    @OneToMany
    private Set<GroupEdu> groupEduSet = new HashSet<GroupEdu>();


    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;


    public Student() {
    }

    public Student(Long id, String name, String lastname, Date birthday, String passportId, Subject subject, Date createdate, Course course, Date exitdate, Set<GroupEdu> groupEduSet, Active active) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.passportId = passportId;
        this.subject = subject;
        this.createdate = createdate;
        this.course = course;
        this.exitdate = exitdate;
        this.groupEduSet = groupEduSet;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getExitdate() {
        return exitdate;
    }

    public void setExitdate(Date exitdate) {
        this.exitdate = exitdate;
    }

    public Set<GroupEdu> getGroupEduSet() {
        return groupEduSet;
    }

    public void setGroupEduSet(Set<GroupEdu> groupEduSet) {
        this.groupEduSet = groupEduSet;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }
}
