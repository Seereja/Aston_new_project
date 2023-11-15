package hw2_smale_project.mapper;

import hw2_smale_project.model.Section;
import hw2_smale_project.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionMapper {
    public Section toSection(ResultSet resultSet) throws SQLException {
        Section section = new Section();
        section.setId(resultSet.getInt("id"));
        section.setName(resultSet.getString("name"));
        return section;
    }

    public Section toSectionOfString(ResultSet resultSet) throws SQLException {
        Section sections = new Section();
        while (resultSet.next()) {
            toSection(resultSet);
        }
        return sections;
    }
}
