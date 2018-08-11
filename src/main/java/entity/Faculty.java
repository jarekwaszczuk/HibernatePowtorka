package entity;

import com.sun.deploy.security.ValidationState;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Faculty extends AbstractEntityName {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Set<Room> rooms;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_course",
            joinColumns = {@JoinColumn(name = "faculty_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_lecturer",
            joinColumns = {@JoinColumn(name = "faculty_id")},
            inverseJoinColumns = {@JoinColumn(name = "lecturer_id")}
    )
    private Set<Lecturer> lecturers;
}
