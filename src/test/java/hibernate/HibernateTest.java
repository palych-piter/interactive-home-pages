package hibernate;

import core.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Andrey on 10/18/2015.
 */
public class HibernateTest extends Assert {
    @Test
    public void UserHibernate() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }
}
