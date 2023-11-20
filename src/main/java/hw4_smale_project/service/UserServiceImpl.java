package hw4_smale_project.service;

import hw4_smale_project.model.User;
import hw4_smale_project.repository.UserDAOImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAOImpl;

    public UserServiceImpl() {
        userDAOImpl = new UserDAOImpl();
    }

    public UserServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Transactional
    @Override
    public List<User> getAllUser() throws SQLException {
        return userDAOImpl.getAllUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAOImpl.saveUser(user);
    }

    @Override
    @Transactional

    public User getUser(int id) {
        return userDAOImpl.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDAOImpl.deleteUserById(id);
    }
}
