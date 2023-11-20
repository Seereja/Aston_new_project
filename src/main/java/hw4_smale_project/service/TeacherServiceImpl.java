package hw4_smale_project.service;

import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.TeacherDAOImpl;
import jakarta.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherDAOImpl teacherDAOImpl;

    public TeacherServiceImpl(TeacherDAOImpl teacherDAOImpl) {
        this.teacherDAOImpl = teacherDAOImpl;
    }

    @Override
    @Transactional

    public List<Teacher> getAllTeacher() throws SQLException {
        return teacherDAOImpl.getAllTeacher();
    }

    @Override
    @Transactional

    public void saveTeacher(Teacher teacher) {
        teacherDAOImpl.saveTeacher(teacher);
    }

    @Override
    @Transactional

    public User getTeacher(int id) {
        return teacherDAOImpl.getTeacher(id);
    }

    @Override
    @Transactional

    public void deleteTeacherById(int id) {
        teacherDAOImpl.deleteTeacherById(id);
    }
}
