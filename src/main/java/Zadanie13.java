import entity.Faculty;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.HashSet;
import java.util.Set;

public class Zadanie13 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Faculty usunacKaskadowo = session.get(Faculty.class, 23);

        session.delete(usunacKaskadowo);

        transaction.commit();
        session.close();
        HibernateUtils.close();
    }
}
