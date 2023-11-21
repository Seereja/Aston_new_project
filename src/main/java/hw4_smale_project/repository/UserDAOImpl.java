package hw4_smale_project.repository;

import hw4_smale_project.DTO.UserDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final UserDTO userDTO;

    public UserDAOImpl(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDAOImpl() {
        this.userDTO = new UserDTO();
    }

    @Override
    public List<UserDTO> getAllUser() throws SQLException {
        Transaction transaction = null;
        List<UserDTO> userDTOS = new ArrayList<>();
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "SELECT new hw4_smale_project.DTO.UserDTO(u.id,u.name,u.surname,u.email,u.phone,u.age)from User as u";
        List<UserDTO> users = session.createQuery(hql, UserDTO.class).getResultList();
        userDTOS.addAll(users);
        transaction.commit();
        session.close();
        return userDTOS;
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
