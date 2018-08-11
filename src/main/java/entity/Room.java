package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty facultyId;
}
