package hw4_smale_project.service;

import hw4_smale_project.model.Child;

import java.sql.SQLException;
import java.util.List;

public interface ChildService {
    public List<Child> getAllChildren() throws SQLException;

    void saveChildren(Child child);

    Child getChildren(int id);

    void deleteChildren(int id);

    List<Child> getChildrenForSectionId(int id) throws ClassNotFoundException;
}
