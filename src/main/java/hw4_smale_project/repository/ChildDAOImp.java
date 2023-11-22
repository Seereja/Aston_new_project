package hw4_smale_project.repository;

import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.mapper.ChildMapper;
import hw4_smale_project.mapperInterface.ChildModelMapper;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.ChildDAO;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ChildDAOImp implements ChildDAO {

    private final ChildDTO childDTO;
    private ChildMapper childMapper;

    public ChildDAOImp(ChildDTO childDTO) {
        this.childDTO = childDTO;
    }

    public ChildDAOImp() {
        this.childDTO = new ChildDTO();
    }


    @Override
    public List<ChildDTO> getAllChildren() {
        Transaction transaction = null;
        List<Child> children = new ArrayList<>();
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Child";
            List<Child> list = session.createQuery(hql, Child.class).getResultList();
            children.addAll(list);
            transaction.commit();
        }
        return children.stream().map(ChildModelMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ChildDTO getChildById(int id) {
        Transaction transaction = null;
        Child child = null;
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            child = session.get(Child.class, id);
            if (child != null) {
                Hibernate.initialize(child.getSections());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return ChildModelMapper.INSTANCE.toDTO(child);
    }

    @Override
    public List<Child> getAllChildrenAndSection() {
        Transaction transaction = null;
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Child AS c LEFT JOIN FETCH c.sections";
            List<Child> children = session.createQuery(hql, Child.class).getResultList();
            transaction.commit();
            session.close();
            return children;
        }
    }

    @Override
    public void saveChildren(User user) {
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }


    @Override
    public void deleteChildren(int id) {
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Child> childQuery = session.createQuery("delete from Child where id=:id");
        childQuery.setParameter("id", id);
        childQuery.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<ChildDTO> getChildrenBySectionId(int id) {
        List<Child> children;
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "SELECT  c " +
                "FROM Child c " +
                "INNER JOIN c.sections s " +
                "WHERE s.id = :sectionId";
        children = session.createQuery(hql, Child.class).setParameter("sectionId", id).getResultList();
        transaction.commit();
        session.close();
        return children.stream().map(ChildModelMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


}
