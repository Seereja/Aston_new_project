package hw4_smale_project.repository;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.mapper.SectionMapper;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;
import hw4_smale_project.model.Teacher;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class SectionDAOImp implements SectionDAO {


    SessionFactory sessionFactory;

    @Transactional
    @Override
    public Section findSectionByTeacherId(int id) {
        Section resultSection = null;
        String hql = "SELECT s.id, s.name FROM Teacher t JOIN t.section s WHERE t.id = :teacher_id";
        Session session = DBConfig.getSessionFactory().openSession();
        Query<Section> section = session.createQuery(hql, Section.class);
        section.setParameter("teacher_id", id);
        resultSection = section.uniqueResult();
        return resultSection;
    }

    @Override
    public List<Section> getAllSection() throws SQLException {
        Session session = DBConfig.getSessionFactory().openSession();
        List<Section> sections = session.createQuery("from Session", Section.class).getResultList();
        return sections;
    }

    @Override
    public void saveSection(Section section) {
        Session session = DBConfig.getSessionFactory().openSession();
        session.persist(section);
    }

    @Override
    public Section getSectionById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Section section = session.get(Section.class, id);
        return section;
    }

    @Override
    public void deleteSectionById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query<Section> sectionQuery = session.createQuery("delete from Section where id=:id");
        sectionQuery.setParameter("id", id);
        sectionQuery.executeUpdate();
    }

}

