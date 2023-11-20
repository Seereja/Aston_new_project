package hw4_smale_project.repository;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUser() throws SQLException {
        Session session = DBConfig.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public void saveUser(User user) {
        Session session = DBConfig.getSessionFactory().openSession();
        session.persist(user);
    }

    @Override
    public User getUser(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query user = session.createQuery("delete from User where id=:id");

        user.setParameter("id", id);
        user.executeUpdate();
    }
}
