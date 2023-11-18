package hw4_smale_project.mapper;

import hw4_smale_project.model.Section;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper {
    public Section toSection(ResultSet resultSet) throws SQLException {
        Section section = new Section();
//        section.setId(resultSet.getInt("id"));
        section.setName(resultSet.getString("name"));
        return section;
    }

    public Section toSectionOfString(ResultSet resultSet) throws SQLException {
        Section sections = new Section();
//        sections.setId(resultSet.getInt("id"));
        sections.setName(resultSet.getString("name"));
        return sections;
    }
}
