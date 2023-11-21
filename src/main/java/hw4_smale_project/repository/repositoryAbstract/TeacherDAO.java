package hw4_smale_project.repository.repositoryAbstract;

import hw4_smale_project.model.Section;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    public List<Teacher> getAllTeacher() throws SQLException;

    void saveTeacher(Teacher teacher);

    void saveUserAndTeacherAndSection(User user, Teacher teacher);

    User getTeacher(int id);

    void deleteTeacherById(int id);
}
