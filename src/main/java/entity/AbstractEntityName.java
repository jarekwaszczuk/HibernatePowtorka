package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntityName extends AbstractEntity {

    private String name;

    @Override
    public String toString() {
        return getName();
    }
}
