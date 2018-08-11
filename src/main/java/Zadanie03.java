import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie03 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();

        Query<Room> query = session.createQuery("select r from Room r", Room.class);

        List<Room> resultList = query.getResultList();

        transaction.commit();

        session.close();

        HibernateUtils.close();

        System.out.println(resultList);
        System.out.println("Rekordów: " + resultList.size());

    }
}