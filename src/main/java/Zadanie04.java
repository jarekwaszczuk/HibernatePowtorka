import entity.Faculty;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie04 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();

        Query<Room> query = session.createQuery("select r from Room r where r.faculty.name = :faculty", Room.class);
        query.setParameter("faculty", "Wydział Humanistyczny");

        List<Room> resultList = query.getResultList();

        transaction.commit();

        session.close();

        HibernateUtils.close();

        System.out.println(resultList);
        System.out.println("Rekordów: " + resultList.size());

    }
}
