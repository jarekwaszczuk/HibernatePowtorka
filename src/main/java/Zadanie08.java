import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie08 {

    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();

        Query<Faculty> query = session.createQuery("select distinct f from Faculty f " +
                "join fetch f.rooms " +
                "join fetch f.courses " +
                "join fetch f.lecturers", Faculty.class);

        List<Faculty> resultList = query.getResultList();

        transaction.commit();

        session.close();

        HibernateUtils.close();

        System.out.println(resultList);
        System.out.println("Rekordów: " + resultList.size());

//        lambda do wyświetlenia
//        resultList.forEach(System.out::println);

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println("(" + resultList.get(i) + ")");
            System.out.println(resultList.get(i).getCourses());
            System.out.println(resultList.get(i).getRooms());
            System.out.println(resultList.get(i).getLecturers());
        }
    }
}
