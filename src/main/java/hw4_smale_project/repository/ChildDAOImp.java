package hw4_smale_project.repository;

import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.DTO.ChildSectionDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.ChildDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class ChildDAOImp implements ChildDAO {

    private final ChildDTO childDTO;

    public ChildDAOImp(ChildDTO childDTO) {
        this.childDTO = childDTO;
    }

    public ChildDAOImp() {
        this.childDTO = new ChildDTO();
    }

    @Override
    public List<ChildDTO> getAllChildren() {
        Transaction transaction = null;
        List<ChildDTO> childDTOs = new ArrayList<>();
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT new hw4_smale_project.DTO.ChildDTO(c.id, c.name, c.surname, c.categoryInSports) FROM Child AS c";
            List<ChildDTO> list = session.createQuery(hql, ChildDTO.class).getResultList();
            childDTOs.addAll(list);
            transaction.commit();
            session.close();
            return childDTOs;
        }
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
    public Child getChildren(int id) {
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Child child = session.get(Child.class, id);
        transaction.commit();
        session.close();
        return child;
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
    public List<ChildSectionDTO> getChildrenBySectionId(int id) {
        List<ChildSectionDTO> children;
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        // Изобновленный HQL запрос, используя выборку конструктора
        String hql = "SELECT  c.id, c.name, c.surname, c.age, c.categoryInSports, s.sectionName " +
                "FROM Child c " +
                "INNER JOIN c.sections s " +
                "WHERE s.id = :sectionId";
        children = session.createQuery(hql, ChildSectionDTO.class).setParameter("sectionId", id).getResultList();
        transaction.commit();
        session.close();
        return children;
    }

    @Override
    public void addChildrenToSection(Child child) {

    }

}
