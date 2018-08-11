import entity.Faculty;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.HashSet;
import java.util.Set;

public class Zadanie12 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Faculty faculty = new Faculty();
        faculty.setName("Wydział z pokojami");
        Set<Room> rooms = new HashSet<>();
        Room room1 = new Room();
        room1.setName("Pokój 111");
        room1.setFaculty(faculty);
        Room room2 = new Room();
        room2.setName("Pokój 222");
        room2.setFaculty(faculty);
        rooms.add(room1);
        rooms.add(room2);

        faculty.setRooms(rooms);

        session.persist(faculty);

        transaction.commit();
        session.close();
        HibernateUtils.close();
    }
}
