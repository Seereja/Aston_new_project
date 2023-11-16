package hw2_smale_project.repository;

import hw2_smale_project.model.Section;

import java.sql.SQLException;

public interface SectionDAO {

    public Section findSectionByTeacherId(int id) throws SQLException, ClassNotFoundException;

}
