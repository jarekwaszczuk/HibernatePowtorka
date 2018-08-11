import entity.Faculty;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.Arrays;
import java.util.List;

public class Zadanie05 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();

        Query<Faculty> query = session.createQuery("select f from Faculty f", Faculty.class);

        List<Faculty> resultList = query.getResultList();

        transaction.commit();

        session.close();

        HibernateUtils.close();

        System.out.println(resultList);
        System.out.println("Rekordów: " + resultList.size());
        //TODO przerobić poniższe na forEach
        System.out.println(resultList.get(0).getRooms());
        System.out.println("Ile pokoi: " + resultList.get(0).getRooms().size() + " (" + resultList.get(1).getName() + ")");
        System.out.println(resultList.get(1).getRooms());
        System.out.println("Ile pokoi: " + resultList.get(1).getRooms().size() + " (" + resultList.get(1).getName() + ")");

    }
}