package hw4_smale_project.repository;

import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUser() throws SQLException;

    void saveUser(User user);

    User getUser(int id);

    void deleteUserById(int id);
}
