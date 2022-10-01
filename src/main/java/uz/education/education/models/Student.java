package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.education.education.models.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

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
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    private Date exitdate;


    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;



}
