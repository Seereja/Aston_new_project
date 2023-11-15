package hw2_smale_project.servletManyToMany;

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

import static hw2_smale_project.DBConstants.*;

public class ManyToMany extends HttpServlet {

    private ChildMapper childMapper;


    public ManyToMany(ChildMapper childMapper) throws SQLException {
        this.childMapper = childMapper;
    }

    public ManyToMany() throws SQLException {
        this.childMapper = new ChildMapper();

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

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://"
                            + DB_HOST
                            + ":"
                            + PORT
                            + "/"
                            + DB_NAME,
                    USER,
                    PASSWORD);
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT " +
                            "c.id as id, " +
                            "c.name AS name, " +
                            "c.surname AS surname," +
                            "c.age AS age," +
                            "s.name AS name " +
                            "FROM " +
                            "children AS c " +
                            "INNER JOIN " +
                            "children_section AS cs ON c.id = cs.children_id " +
                            "INNER JOIN " +
                            "sections AS s ON s.id = 2");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                child = childMapper.toChildList(resultSet);
                System.out.println(child);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
        super.doGet(req, resp);
    }
}
