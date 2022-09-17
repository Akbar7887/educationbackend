package uz.education.education.models.user;

import javax.persistence.*;
import java.util.Date;

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
    //OneToOne()

}
