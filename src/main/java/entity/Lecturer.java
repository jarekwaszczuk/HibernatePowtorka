package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Lecturer extends AbstractEntity{

    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private LecturerGrade grade;

}
