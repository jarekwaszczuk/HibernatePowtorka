import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie06 {
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

        for(int i=0;i < resultList.size();i++){
            System.out.println(resultList.get(i).getCourses());
            System.out.println("Ile kursów: " + resultList.get(i).getCourses().size() + " (" + resultList.get(i).getName() + ")");
        }
    }
}
