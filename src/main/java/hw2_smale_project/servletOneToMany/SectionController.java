package hw2_smale_project.servletOneToMany;

import hw2_smale_project.config.DBConfig;
import hw2_smale_project.mapper.SectionMapper;
import hw2_smale_project.model.Section;
import hw2_smale_project.service.SectionDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SectionController extends HttpServlet {

    private final SectionDAOImpl sectionDAOImpl;

    public SectionController() {
        this.sectionDAOImpl = new SectionDAOImpl(new DBConfig(), new SectionMapper());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Section section = sectionDAOImpl.findSectionByTeacherId(2);
        req.setAttribute("section", section);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

        super.doGet(req, resp);


    }
}

