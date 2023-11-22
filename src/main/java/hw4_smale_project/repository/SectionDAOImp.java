package hw4_smale_project.repository;

import hw4_smale_project.DTO.SectionDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.mapperInterface.SectionModelMapper;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.repository.repositoryAbstract.SectionDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SectionDAOImp implements SectionDAO {

    @Override
    public SectionDTO findSectionByTeacherId(int id) {
        SectionDTO sectionDTO = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "FROM Teacher t WHERE t.id = :teacher_id";
            Query<Teacher> query = session.createQuery(hql, Teacher.class).setParameter("teacher_id", id);
            Teacher teacher = query.uniqueResult();
            if (teacher != null) {
                Section section = teacher.getSection();
                sectionDTO = SectionModelMapper.INSTANCE.toDTO(section);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return sectionDTO;
    }


    @Override
    public List<SectionDTO> getAllSection() {
        Transaction transaction = null;
        List<Section> sections = new ArrayList<>();
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "from Section";
            List<Section> list = session.createQuery(hql, Section.class).getResultList();
            sections.addAll(list);
            transaction.commit();
        }
        return sections.stream().map(SectionModelMapper.INSTANCE::toDTO).collect(Collectors.toList());

    }


    @Override
    public void saveSection(Section section) {

        try (Session session = DBConfig.getSessionFactory().openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.persist(section);
            transaction.commit();
        }
    }

    @Override
    public SectionDTO getSectionById(int id) {
        Transaction transaction = null;
        Section section = null;
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            section = session.get(Section.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return SectionModelMapper.INSTANCE.toDTO(section);

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

}

