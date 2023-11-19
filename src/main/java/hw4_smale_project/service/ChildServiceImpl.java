package hw4_smale_project.service;

import hw4_smale_project.model.Child;
import hw4_smale_project.repository.ChildDAO;
import hw4_smale_project.repository.ChildDAOImp;
import jakarta.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;

public class ChildServiceImpl implements ChildService {
    private final ChildDAOImp childDAOImp;

    public ChildServiceImpl(ChildDAOImp childDAOImp) {
        this.childDAOImp = childDAOImp;

    }


    @Override
    @Transactional
    public List<Child> getAllChildren() throws SQLException {
        return childDAOImp.getAllChildren();
    }

    @Override
    @Transactional
    public void saveChildren(Child child) {
        childDAOImp.saveChildren(child);
    }

    @Override
    @Transactional
    public Child getChildren(int id) {
        return childDAOImp.getChildren(id);
    }

    @Override
    @Transactional
    public void deleteChildren(int id) {
        childDAOImp.deleteChildren(id);
    }

    @Override
    @Transactional
    public List<Child> getChildrenForSectionId(int id) {
        List<Child> children = null;
        try {
            children = childDAOImp.getChildrenForSectionId(id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        children.stream().map(Child::getName).forEach(System.out::println);
        return children;
    }
}

