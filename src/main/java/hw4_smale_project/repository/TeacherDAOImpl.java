package hw4_smale_project.repository;

import hw4_smale_project.DTO.TeacherDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.TeacherDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeacherDAOImpl implements TeacherDAO {

    private final TeacherDTO teacherDTO;

    public TeacherDAOImpl(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public TeacherDAOImpl() {
        this.teacherDTO = new TeacherDTO();
    }

    @Override
    public List<TeacherDTO> getAllTeacher() throws SQLException {
        Transaction transaction = null;
        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        try (Session session = DBConfig.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            String hql = "SELECT new hw4_smale_project.DTO.TeacherDTO(t.id,t.name,t.surname,t.category) FROM Teacher AS t";
            List<TeacherDTO> teachers = session.createQuery(hql, TeacherDTO.class).getResultList();
            teacherDTOS.addAll(teachers);
            transaction.commit();
            session.close();
            return teacherDTOS;
        }

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
