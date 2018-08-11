import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

public class Zadanie11 {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Faculty doUsuniecia = session.get(Faculty.class, 14);

        session.delete(doUsuniecia);
        transaction.commit();
        session.close();
        HibernateUtils.close();
    }
}
