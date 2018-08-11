import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtils;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();

        HibernateUtils.close();

    }
}
