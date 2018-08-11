package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Lecturer extends AbstractEntityName{

    private String surname;
    @Enumerated(EnumType.STRING)
    private LecturerGrade grade;

}
