package hw3_smale_project.repository;

import hw3_smale_project.config.DBConfig;
import hw3_smale_project.mapper.ChildMapper;
import hw3_smale_project.model.Child;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildDAO {

    private final DBConfig dbConfig;

    private final ChildMapper childMapper;

    public ChildDAO(DBConfig dbConfig, ChildMapper childMapper) {
        this.dbConfig = dbConfig;
        this.childMapper = childMapper;
    }

    public List<Child> getChildrenForSectionId(int id) throws SQLException, ClassNotFoundException {
        List<Child> children = new ArrayList<>();
        try (Connection connection = dbConfig.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.id as id, c.name AS name, c.surname AS surname, c.age AS age, s.name AS secname FROM children AS c INNER JOIN children_section AS cs ON c.id = cs.children_id INNER JOIN sections AS s ON cs.section_id = s.id WHERE s.id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Child currentChild = childMapper.toChild(resultSet);
                if (currentChild != null) {
                    children.add(currentChild);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return children;
    }
}
