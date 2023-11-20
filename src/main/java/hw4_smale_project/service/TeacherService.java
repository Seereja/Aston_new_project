package hw4_smale_project.service;

import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeacher() throws SQLException;

    void saveTeacher(Teacher teacher);

    User getTeacher(int id);

    void deleteTeacherById(int id);
}
