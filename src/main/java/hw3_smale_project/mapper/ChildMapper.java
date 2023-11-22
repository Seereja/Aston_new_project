package hw3_smale_project.mapper;

import hw3_smale_project.model.Child;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildMapper {
    public Child toChild(ResultSet resultSet) throws SQLException {
        Child child = new Child();
        child.setId(resultSet.getInt("id"));
        child.setName(resultSet.getString("name"));
        child.setSurname(resultSet.getString("surname"));
        child.setAge(resultSet.getInt("age"));
        return child;
    }

    public List<Child> toChildList(ResultSet resultSet) throws SQLException {
        List<Child> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(toChild(resultSet));
        }
        return list;
    }
}
