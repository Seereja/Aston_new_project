package hw4_smale_project;

import hw4_smale_project.config.DBConfig;
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

//            done
//            childService.getAllChildren();
//            userService.getAllUser();
//            teacherService.getAllTeacher();
//            sectionService.getAllSection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

            System.out.println(childService.getChildById(4));
//            System.out.println(teacherService.getTeacherById(10));
//            System.out.println(userService.getUserById(4));

//            User user = new User();
//            user.setName("Yana");
//            user.setSurname("Ganga");
//            user.setEmail("Ganga@asdads123.com");
//            user.setPhone(8123123);
//            user.setAge(81);
//            userService.saveUser(user);
//            Teacher teacher = new Teacher();
//
//            teacher.setCategory("midl");
//            teacher.setSection(sectionService.getSectionById(1));
//            teacherService.saveTeacher(teacher);
//            teacherService.deleteTeacherById(2);

//            Teacher teacher = new Teacher();
//            teacher.setName("Sergey");
//            teacher.setSurname("Shilin");
//            teacher.setAge(28);
//            teacher.setPhone(281212);
//            teacher.setEmail("фывфвфв");
//            teacher.setSection(sectionService.getSectionById(2));
//            teacher.setCategory("junior");
//            teacherService.saveTeacher(teacher);
//            teacher.setSection(sectionService.getSectionById(2));

        }
    }
}

