package hw4_smale_project;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Section;
import hw4_smale_project.model.Teacher;
import hw4_smale_project.model.User;
import hw4_smale_project.service.*;
import org.hibernate.Session;

import java.sql.SQLException;

public class Test2 {

    public static void main(String[] args) {
        try (Session session = DBConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            UserServiceImpl userService1 = new UserServiceImpl();
            ChildServiceImpl childService = new ChildServiceImpl();
            TeacherServiceImpl teacherService = new TeacherServiceImpl();
            SectionServiceImpl sectionService = new SectionServiceImpl();

            System.out.println(childService.getChildrenBySectionId(2));
        }
    }
}
