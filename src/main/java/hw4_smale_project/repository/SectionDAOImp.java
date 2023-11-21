package hw4_smale_project.repository;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;
import hw4_smale_project.repository.repositoryAbstract.SectionDAO;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public class SectionDAOImp implements SectionDAO {

    @Override
    public Section findSectionByTeacherId(int id) {
        String hql = "SELECT s.id, s.sectionName FROM Teacher t JOIN t.section s WHERE t.id = :teacher_id";
        Session session = DBConfig.getSessionFactory().openSession();
        Section resultSection = null;
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<Section> section = session.createQuery(hql, Section.class);
        section.setParameter("teacher_id", id);
        resultSection = section.uniqueResult();
        transaction.commit();
        session.close();
        return resultSection;
    }

    @Override
    @Transactional
    public List<Section> getAllSection() throws SQLException {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<Section> sections = session.createQuery("from Section ", Section.class).getResultList();
        transaction.commit();
        session.close();
        return sections;

    }

    @Override
    public void saveSection(Section section) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.persist(section);
        transaction.commit();
        session.close();
    }

    @Override
    @Transactional
    public Section getSectionById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Section section = session.get(Section.class, id);
        transaction.commit();
        session.close();
        return section;
    }

    @Override
    public void deleteSectionById(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query sectionQuery = session.createQuery("delete from Section where id=:sectionId");
        sectionQuery.setParameter("sectionId", id);
        transaction.commit();
        session.close();
        sectionQuery.executeUpdate();
    }

    @Override
    public void saveChildInSection(Child child) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.persist(child);
        transaction.commit();
        session.close();
    }

}

