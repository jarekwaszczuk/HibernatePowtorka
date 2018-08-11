package util;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }

    public static void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }

    private static void buildSessionFactory() {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Map<String, String> properties = new HashMap();
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/createhibernate?useUnicode=yes&characterEncoding=utf8");
        properties.put(Environment.USER, "sda");
        properties.put(Environment.PASS, "pass");
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.POOL_SIZE, "1");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "create");

        registryBuilder.applySettings(properties);

        StandardServiceRegistry serviceRegistry = registryBuilder.build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Faculty.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Lecturer.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Semester.class)

                .buildMetadata();

        sessionFactory = metadata.buildSessionFactory();
    }



    public static <T> T doInTransaction(Function<Session, T> queryAction) {
        return doInTransaction(getSession(), queryAction);
    }

    public static <T> T doInTransaction(Session session, Function<Session, T> queryAction) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return queryAction.apply(session);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            if (transaction != null && transaction.getStatus() != TransactionStatus.MARKED_ROLLBACK) {
                transaction.commit();
            }
        }
    }


}
