package hw4_smale_project.repository;

import hw4_smale_project.DTO.ChildSectionDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;
import hw4_smale_project.repository.repositoryAbstract.ChildDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;



public class ChildDAOImp implements ChildDAO {

    @Override
    public List<Child> getAllChildren() throws SQLException {
        Transaction transaction = null;
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Child c JOIN FETCH c.sections s JOIN FETCH s.children";
            List<Child> children = session.createQuery(hql).getResultList();
            transaction.commit();
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
    }


    @Override

    public Child getChildren(int id) {
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Child child = session.get(Child.class, id);
        transaction.commit();
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
                "WHERE s.id = :id";
        children = session.createQuery(hql, ChildSectionDTO.class).setParameter("id", id).getResultList();
        transaction.commit();
        session.close();
        return children;
    }

    @Override
    public void addChildrenToSection(Child child) {

    }

}
