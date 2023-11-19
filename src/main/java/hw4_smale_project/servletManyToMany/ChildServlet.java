package hw4_smale_project.servletManyToMany;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.mapper.ChildMapper;
import hw4_smale_project.model.Child;
import hw4_smale_project.repository.ChildDAOImp;
import hw4_smale_project.service.ChildServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class ChildServlet extends HttpServlet {

    //    private final ChildServiceImpl childDAOimpl;
//    private final DBConfig dbConfig;
    private SessionFactory factory;

//    public ChildServlet(DBConfig dbConfig) {
//        this.dbConfig = dbConfig;
//        this.childDAOimpl = new ChildServiceImpl(new ChildDAOImp(new DBConfig(), new ChildMapper()));
//    }


//    @Override
//    public void init() throws ServletException {
//        // создаем hibernate конфигурацию
//        Configuration cfg = new Configuration();
//        cfg.configure();
//
//        factory = cfg.buildSessionFactory();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        Configuration configuration = new Configuration().configure();
        // создаем новую сессию
        Session session = DBConfig.getSessionFactory().openSession();
        // вместо кастомной реализации DAO мы использовали встроенный метод `createQuery`
        List<Child> children = session.createQuery("from Child c where c.id = 1").list();
        // закрываем сессию
        session.close();
        req.setAttribute("child", children);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        factory.close(); // правильно закрыть фабрику сессий при уничтожении сервлета
    }

}
