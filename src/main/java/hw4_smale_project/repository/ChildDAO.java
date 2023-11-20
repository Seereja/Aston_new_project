package hw4_smale_project.repository;


import hw4_smale_project.model.Child;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ChildDAO {
    public List<Child> getAllChildren() throws SQLException;

    void saveChildren(Child child);

    Child getChildren(int id);

    void deleteChildren(int id);

    List<Child> getChildrenForSectionId(int id) throws ClassNotFoundException;

    public void addChildrenToSection(Child child);
}