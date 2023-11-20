package hw4_smale_project.repository;

import hw4_smale_project.DTO.ChildSectionDTO;
import hw4_smale_project.config.DBConfig;
import hw4_smale_project.mapper.ChildMapper;
import hw4_smale_project.model.Child;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

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
    public void saveChildren(Child child) {
        Transaction transaction = null;
        Session session = DBConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.persist(child);
        transaction.commit();

    }

    @Override

    public Child getChildren(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Child child = session.get(Child.class, id);
        return child;
    }

    @Override
    public void deleteChildren(int id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query<Child> childQuery = session.createQuery("delete from Child where id=:id");
        childQuery.setParameter("id", id);
        childQuery.executeUpdate();
    }

    @Override
    public List<ChildSectionDTO> getChildrenBySectionId(int id) {
        List<ChildSectionDTO> children;
        Session session = DBConfig.getSessionFactory().openSession();
        // Изобновленный HQL запрос, используя выборку конструктора
        String hql = "SELECT new hw4_smale_project.DTO.ChildSectionDTO(c.id, c.name, c.surname, c.age, c.categoryInSports, s.sectionName) " +
                "FROM Child c " +
                "INNER JOIN c.sections s " +
                "WHERE s.id = :id";
        children = session.createQuery(hql, ChildSectionDTO.class).setParameter("id", id).getResultList();
        return children;
    }

    @Override
    public void addChildrenToSection(Child child) {

    }

}
