
package dao;

import core.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MessageDAOImpl implements MessageDAO {

    private static final Logger logger = LoggerFactory.getLogger(MessageDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public void addMessage(Message p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Message saved successfully, Message Details= " + p);
    }


    @Override
    public void updateMessage(Message p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Message updated successfully, Message Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> listMessages() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Message> messagesList =
                session.createQuery("from Message").list();
        for (Message p : messagesList) {
            logger.info("Message List::" + p);
        }
        return messagesList;
    }

    @Override
    public Message getMessageById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Message p = (Message) session.load(Message.class, new Integer(id));
        logger.info("Message loaded successfully, Message details= " + p);
        return p;
    }

    @Override
    public void removeMessage(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Message p = (Message) session.load(Message.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Message deleted successfully, message details= " + p);
    }

}





