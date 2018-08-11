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

}
