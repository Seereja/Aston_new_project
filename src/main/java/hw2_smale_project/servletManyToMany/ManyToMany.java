package hw2_smale_project.dao;

import hw2_smale_project.mapper.ChildMapper;
import hw2_smale_project.model.Child;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManyToMany extends HttpServlet {

    private final Connection connection;
    private final ChildMapper childMapper;

    public ManyToMany(Connection connection, ChildMapper childMapper) {
        this.connection = connection;
        this.childMapper = childMapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Child> child = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    connection.prepareStatement("SELECT c.name AS child_name, c.surname AS child_surname, s.name AS section_name " +
                            "FROM children c " +
                            "JOIN children_section cs ON c.id = cs.children_id " +
                            "JOIN sections s ON s.id = cs.section_id");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                child = childMapper.toChildList(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        req.setAttribute("child", child);
        super.doGet(req, resp);
    }
}
