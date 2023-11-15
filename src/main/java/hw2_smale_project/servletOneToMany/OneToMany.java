package hw2_smale_project.dao;

import hw2_smale_project.mapper.TeacherMapper;
import hw2_smale_project.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OneToMany extends HttpServlet {

    private final Connection connection;
    private final TeacherMapper teacherMapper;

    public OneToMany(Connection connection, TeacherMapper teacherMapper) {
        this.connection = connection;
        this.teacherMapper = teacherMapper;

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Teacher> teachers = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT teachers.* " +
                            "FROM teachers " +
                            "JOIN sections ON teachers.section_id = sections.id " +
                            "WHERE sections.id = ?");

            preparedStatement.setInt(1, 2);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                teachers.add(teacherMapper.toTeacher(resultSet));
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
        req.setAttribute("teachers", teachers);

        super.doGet(req, resp);


    }
}

