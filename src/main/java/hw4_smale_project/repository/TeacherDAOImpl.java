package hw4_smale_project.repository;

import hw4_smale_project.DTO.TeacherDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.mapperInterface.TeacherModelMapper;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.repository.repositoryAbstract.TeacherDAO;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
        List<Teacher> teachers = new ArrayList<>();
        try (Session session = DBConfig.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            String hql = "FROM Teacher";
            List<Teacher> list = session.createQuery(hql, Teacher.class).getResultList();
            teachers.addAll(list);
            transaction.commit();
            session.close();
        }
        return teachers.stream().map(TeacherModelMapper.INSTANCE::toDTO).collect(Collectors.toList());
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
    public TeacherDTO getTeacherById(int id) {
        Transaction transaction = null;
        Teacher teacher = null;
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, id);
            if (teacher != null) {
                Hibernate.initialize(teacher.getSection()); // этот код инициализирует свойство 'sections'
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return TeacherModelMapper.INSTANCE.toDTO(teacher);
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
