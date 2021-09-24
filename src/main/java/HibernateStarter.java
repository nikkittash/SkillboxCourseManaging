import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateStarter {

    public HibernateStarter() {
    }

    private static Session session;

    private static SessionFactory sessionFactory;

    private static Transaction transaction;

    protected static void initializationConnection(String hibernate) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(hibernate).build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        setSessionFactory(metadata.getSessionFactoryBuilder().build());

        session = getSessionFactory().openSession();
        setTransaction(session.beginTransaction());
    }

    protected static void closeConnection() {
        getTransaction().commit();
        getSessionFactory().close();
    }

    protected static Session getSession() {
        return session;
    }

    private void setSession(Session session) {
        this.session = session;
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateStarter.sessionFactory = sessionFactory;
    }

    private static Transaction getTransaction() {
        return transaction;
    }

    private static void setTransaction(Transaction transaction) {
        HibernateStarter.transaction = transaction;
    }
}

