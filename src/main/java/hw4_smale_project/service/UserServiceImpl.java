package hw4_smale_project.service;

import hw4_smale_project.model.User;
import hw4_smale_project.repository.UserDAOImpl;
import hw4_smale_project.service.serviceAbstract.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAOImpl userDAOImpl;

    public UserServiceImpl() {
        userDAOImpl = new UserDAOImpl();
    }

    public UserServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> users = userDAOImpl.getAllUser();
        users.stream().forEach(System.out::println);
        return users;
    }

    @Override
    public void saveUser(User user) {
        userDAOImpl.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDAOImpl.getUser(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDAOImpl.deleteUserById(id);
    }
}
