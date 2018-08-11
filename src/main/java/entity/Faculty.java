package entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
