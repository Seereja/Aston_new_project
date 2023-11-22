package hw4_smale_project.service;

import hw4_smale_project.DTO.TeacherDTO;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.repository.TeacherDAOImpl;
import hw4_smale_project.service.serviceAbstract.TeacherService;
import jakarta.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;


public class TeacherServiceImpl implements TeacherService {

    private final TeacherDAOImpl teacherDAOImpl;

    public TeacherServiceImpl(TeacherDAOImpl teacherDAOImpl) {
        this.teacherDAOImpl = teacherDAOImpl;
    }

    public TeacherServiceImpl() {
        this.teacherDAOImpl = new TeacherDAOImpl();
    }

    @Override
    @Transactional
    public List<TeacherDTO> getAllTeacher() throws SQLException {
        List<TeacherDTO> teachers = teacherDAOImpl.getAllTeacher();
        teachers.stream().forEach(System.out::println);
        return teachers;
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        teacherDAOImpl.saveTeacher(teacher);
    }

//    @Override
//    public void saveUserAndTeacherAndSection(User user, Teacher teacher) {
//        teacherDAOImpl.saveUserAndTeacherAndSection(user, teacher);
//    }

    @Override
    public TeacherDTO getTeacherById(int id) {
        return teacherDAOImpl.getTeacherById(id);
    }

    @Override
    @Transactional
    public void deleteTeacherById(int id) {
        teacherDAOImpl.deleteTeacherById(id);
    }
}
