package hw2_smale_project.servletOneToMany;

import hw2_smale_project.mapper.ChildMapper;
import hw2_smale_project.mapper.SectionMapper;
import hw2_smale_project.mapper.TeacherMapper;
import hw2_smale_project.model.Section;
import hw2_smale_project.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static hw2_smale_project.DBConstants.*;

public class OneToMany extends HttpServlet {

    private SectionMapper sectionMapper;


    public OneToMany(SectionMapper sectionMapper) throws SQLException {
        this.sectionMapper = sectionMapper;

    }

    public OneToMany() throws SQLException {
        this.sectionMapper = new SectionMapper();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Section section = new Section();
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
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT sections.name " +
                            "FROM teachers " +
                            "JOIN sections ON teachers.section_id = sections.id " +
                            "WHERE teachers.id = 2;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                section = sectionMapper.toSectionOfString(resultSet);
                System.out.println(section);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);

        super.doGet(req, resp);


    }
}

