import entity.Group;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie09 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();

        Query<Group> query = session.createQuery("select c from Group c", Group.class);

        List<Group> resultList = query.getResultList();

        transaction.commit();

        session.close();

        HibernateUtils.close();

        System.out.println(resultList);
        System.out.println("Rekordów: " + resultList.size());

//        lambda do wyświetlenia
//        resultList.forEach(System.out::println);

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println("(" + resultList.get(i) + ")");
            System.out.println(resultList.get(i).getCourse());
            System.out.println(resultList.get(i).getSemester());
        }
    }
}
