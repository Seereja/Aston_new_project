package hw4_smale_project.repository;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Section;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public List<Teacher> getAllTeacher() throws SQLException {
        Session session = DBConfig.getSessionFactory().openSession();
        List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).getResultList();
        return teachers;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session = DBConfig.getSessionFactory().openSession();
        session.persist(teacher);
    }

    @Override
    public User getTeacher(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Teacher teacher = session.get(Teacher.class, id);
        return teacher;
    }

    @Override
    public void deleteTeacherById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query<Teacher> teacherQuery = session.createQuery("delete from Teacher where id=:id");
        teacherQuery.setParameter("id", id);
        teacherQuery.executeUpdate();
    }
}
