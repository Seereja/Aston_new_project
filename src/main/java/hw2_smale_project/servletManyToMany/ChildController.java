package hw2_smale_project.servletManyToMany;

import hw2_smale_project.config.DBConfig;
import hw2_smale_project.mapper.ChildMapper;
import hw2_smale_project.model.Child;
import hw2_smale_project.service.ChildDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ChildController extends HttpServlet {

    private final ChildDAOImpl childDAOimpl;

    public ChildController() {
        this.childDAOimpl = new ChildDAOImpl(new DBConfig(), new ChildMapper());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
        List<Child> children = null;
        try {
            children = childDAOimpl.getChildrenForSectionId(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("child", children);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        super.doGet(req, resp);
    }
}
