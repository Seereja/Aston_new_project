package hw2_smale_project.repository;

import hw2_smale_project.model.Child;

import java.sql.SQLException;
import java.util.List;

public interface ChildDAO {

    public List<Child> getChildrenForSectionId(int id) throws SQLException, ClassNotFoundException;
}
