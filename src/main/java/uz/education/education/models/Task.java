package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String taskname;

    private boolean ans_A;
    private boolean ans_B;
    private boolean ans_C;
    private boolean ans_D;
    private boolean ans_E;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id",
            referencedColumnName = "level_id",
            foreignKey = @ForeignKey(name = "level_id_fx"))
    @JsonBackReference
    private Level level;

    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;


}
