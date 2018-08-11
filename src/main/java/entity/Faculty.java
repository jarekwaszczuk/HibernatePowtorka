package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@ToString
public class Faculty {

    @Id
//    @GenericGenerator(name = "gen", strategy = "increment")
//    @GeneratedValue(generator = "gen", strategy = GenerationType.IDENTITY)
//    do używania w innych bazach, w MySQL wystarczy poniżej
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
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
