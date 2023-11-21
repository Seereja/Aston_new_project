package hw4_smale_project.repository;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getAllUser() throws SQLException {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }


    @Override
    public User getUser(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query user = session.createQuery("delete from User where id=:id");
        user.setParameter("id", id);
        user.executeUpdate();
        transaction.commit();
        session.close();
    }
}
