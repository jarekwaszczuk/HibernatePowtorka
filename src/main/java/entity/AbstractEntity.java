package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass().isInstance(obj)) {
            return ((AbstractEntity) obj).id.equals(id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if(id == null){
            return super.hashCode();
        }
        return id.intValue();
    }
}
