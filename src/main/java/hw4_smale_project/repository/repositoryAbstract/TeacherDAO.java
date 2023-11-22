package hw4_smale_project.repository.repositoryAbstract;

import hw4_smale_project.DTO.TeacherDTO;
import hw4_smale_project.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    public List<TeacherDTO> getAllTeacher() throws SQLException;

    void saveTeacher(Teacher teacher);

    TeacherDTO getTeacherById(int id);

    void deleteTeacherById(int id);
}
