package hw4_smale_project.mapper;

import hw4_smale_project.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherMapper {
    public Teacher toTeacher(ResultSet resultSet) throws SQLException {
        Teacher teacher = new Teacher();
//        teacher.setId(resultSet.getInt("id"));
        teacher.setName(resultSet.getString("name"));
        teacher.setSurname(resultSet.getString("surname"));
        return teacher;
    }

    public List<Teacher> toTeacherList(ResultSet resultSet) throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        while (resultSet.next()) {
            teachers.add(toTeacher(resultSet));
        }
        return teachers;
    }
}
