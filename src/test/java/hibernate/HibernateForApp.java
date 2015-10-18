package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import util.HibernateUtil;


/**
 * Created by Andrey on 10/18/2015.
 */
public class HibernateForApp {

    @Test
    public void UserHibernate() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }
}
