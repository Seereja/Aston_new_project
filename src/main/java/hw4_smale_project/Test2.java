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
            UserServiceImpl userService = new UserServiceImpl();
            ChildServiceImpl childService = new ChildServiceImpl();
            TeacherServiceImpl teacherService = new TeacherServiceImpl();
            SectionServiceImpl sectionService = new SectionServiceImpl();

//            User user = new User("Евгения", "Ильина", "gffas123.gmal.com", 89123213, 26);
//            userService.saveUser(user);
//            User user1 = new User("Юра", "Smith", "smith@gmail.ru", 891180732, 32);
//            userService.saveUser(user1);
//            System.out.println(user1);
//            Section section = sectionService.getSectionById(1);
//            System.out.println(section);

//            System.out.println(sectionService.getAllSection());
//            childService.getAllChildren();
//            Teacher teacher = new Teacher("junior", section);
//            teacherService.saveUserAndTeacherAndSection(user1, teacher);
            userService.getAllUser();
//            childService.getChildrenBySectionId(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
