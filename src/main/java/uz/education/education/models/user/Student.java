package uz.education.education.models.user;

import org.hibernate.annotations.CreationTimestamp;
import uz.education.education.models.Active;
import uz.education.education.models.Course;
import uz.education.education.models.GroupEdu;
import uz.education.education.models.Region;

import javax.persistence.*;
import java.util.Date;

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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private GroupEdu groupEdu;


    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;


    public Student() {
    }

    public Student(Long id, String name, Date birthday, String passportId, String adress, Date createdate, Course course, Region region, Date exitdate, GroupEdu groupEdu, Active active) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.passportId = passportId;
        this.adress = adress;
        this.createdate = createdate;
        this.course = course;
        this.region = region;
        this.exitdate = exitdate;
        this.groupEdu = groupEdu;
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

    public GroupEdu getGroupEdu() {
        return groupEdu;
    }

    public void setGroupEdu(GroupEdu groupEdu) {
        this.groupEdu = groupEdu;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
