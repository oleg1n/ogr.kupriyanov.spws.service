package ogr.kupriyanov.spws.dao;

import ogr.kupriyanov.spws.entity.User;
import ogr.kupriyanov.spws.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() {
        List<User> list;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            list = session.createQuery("SELECT a FROM User a", User.class).getResultList();
        }
        return list;
    }

    @Override
    public User findByLogin(String login) {
        User user;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            user = session.get(User.class, login);
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        if (user == null){
            return false;
        }
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.persist(user);
            tx1.commit();
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        if (user == null){
            return false;
        }
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(user);
            tx1.commit();
        }
        return true;
    }

    @Override
    public boolean delete(String login) {
        User user = findByLogin(login);
        if (user == null){
            return false;
        }
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(user);
            tx1.commit();
        }
        return true;
    }
}