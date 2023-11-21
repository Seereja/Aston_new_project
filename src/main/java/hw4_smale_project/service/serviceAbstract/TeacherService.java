package hw4_smale_project.service.serviceAbstract;

import hw4_smale_project.DTO.TeacherDTO;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    public List<TeacherDTO> getAllTeacher() throws SQLException;

    void saveTeacher(Teacher teacher);

//    void saveTeacherAndSection(User user, Section section);

    void saveUserAndTeacherAndSection(User user, Teacher teacher);

    User getTeacher(int id);

    void deleteTeacherById(int id);
}
