package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Registration implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonIgnore
//    @JsonBackReference
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    @JsonIgnore
//    @JsonBackReference
    private GroupEdu groupEdu;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdate;

    public Registration() {
    }

    public Registration(Student student, GroupEdu groupEdu) {
        this.student = student;
        this.groupEdu = groupEdu;
    }

    public Registration(Long id, Student student, GroupEdu groupEdu, Date createdate) {
        this.id = id;
        this.student = student;
        this.groupEdu = groupEdu;
        this.createdate = createdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public GroupEdu getGroupEdu() {
        return groupEdu;
    }

    public void setGroupEdu(GroupEdu groupEdu) {
        this.groupEdu = groupEdu;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }


    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", student=" + student +
                ", groupEdu=" + groupEdu +
                ", createdate=" + createdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Registration that = (Registration) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
