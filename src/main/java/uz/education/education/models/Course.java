package uz.education.education.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String level;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<GroupEdu> groupSet = new HashSet<>();

    public Course() {
    }

    public Course(Long id, String level, Set<GroupEdu> groupSet) {
        this.id = id;
        this.level = level;
        this.groupSet = groupSet;
    }

    public void addGroup(GroupEdu newgroup) {
        if (!this.groupSet.contains(newgroup)) {
            this.groupSet.add(newgroup);
            newgroup.setCourse(this);
        }
    }

    public void removeGroup(GroupEdu newgroup) {
        if (this.groupSet.contains(newgroup)) {
            this.groupSet.remove(newgroup);
            newgroup.setCourse(null);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Set<GroupEdu> getGroupSet() {
        List<GroupEdu> removelist = new ArrayList<GroupEdu>();
        for (GroupEdu groupEdu : groupSet) {

            if (groupEdu.getActive().equals(Active.NOACTIVE)) {
                removelist.add(groupEdu);
            }
        }
        groupSet.removeAll(removelist);
        return groupSet;
    }

    public void setGroupSet(Set<GroupEdu> groupSet) {

        this.groupSet = groupSet;
    }
}
