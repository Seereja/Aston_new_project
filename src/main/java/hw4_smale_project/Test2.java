package hw4_smale_project;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Section;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;
import hw4_smale_project.service.UserServiceImpl;
import org.hibernate.Session;

public class Test2 {
    private final UserServiceImpl userService;

    public Test2(UserServiceImpl userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {

        try (Session session = DBConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Section section = new Section("VB");
            session.persist(section);
            Teacher teacher = new Teacher();
            
            User user = new User();


        }
    }
}
