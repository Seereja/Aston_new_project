package hw4_smale_project.repository;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.TeacherDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public List<Teacher> getAllTeacher() throws SQLException {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).getResultList();
        transaction.commit();
        session.close();
        return teachers;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.persist(teacher);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUserAndTeacherAndSection(User user, Teacher teacher) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.persist(user);
        session.persist(teacher);
        transaction.commit();
        session.close();
    }

//    @Override
//    public void saveTeacherAndSection(User user, Section section) {
//        Session session = DBConfig.getSessionFactory().openSession();
//        session.persist(user);
//        session.persist(section);
//    }

    @Override
    public User getTeacher(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, id);
        transaction.commit();
        session.close();
        return teacher;
    }

    @Override
    public void deleteTeacherById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<Teacher> teacherQuery = session.createQuery("delete from Teacher where id=:id");
        teacherQuery.setParameter("id", id);
        teacherQuery.executeUpdate();
        transaction.commit();
        session.close();
    }
}
