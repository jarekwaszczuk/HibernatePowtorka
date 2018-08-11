import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class Zadanie02 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select f from Faculty f where f.name like :myname", Faculty.class);
        query.setParameter("myname", "%Human%");

        List<Faculty> resultList = query.getResultList();

        transaction.commit();

        session.close();

        HibernateUtils.close();

        System.out.println(resultList);
    }
}
