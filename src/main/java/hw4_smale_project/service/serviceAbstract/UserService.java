package hw4_smale_project.service.serviceAbstract;

import hw4_smale_project.DTO.UserDTO;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUser() throws SQLException;

    void saveUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);
}
