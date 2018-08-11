import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie10 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Faculty nowyWydzial = new Faculty();
        nowyWydzial.setName("Wydział Robienia Hałasu");

        Transaction transaction = session.beginTransaction();
        session.persist(nowyWydzial);
        transaction.commit();
        session.close();

        Session session2 = HibernateUtils.getSession();
        Transaction transaction2 = session2.beginTransaction();

        Query<Faculty> query2 = session2.createQuery("select distinct f from Faculty f " +
                "left join fetch f.rooms " +
                "left join fetch f.courses " +
                "left join fetch f.lecturers", Faculty.class);

        List<Faculty> resultList = query2.getResultList();

        transaction2.commit();
        session2.close();

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
