package hw4_smale_project;

import hw4_smale_project.config.DBConfig;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;
import hw4_smale_project.model.User;
import hw4_smale_project.service.UserServiceImpl;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {

        try (Session session = DBConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Section section = new Section("VB");
            User user = new User("Р", "фыв", "фыввф", 81929192, 12);
            session.persist(user);
            Child child = new Child("Junior", user);

            Set<Child> children = new HashSet<>();
            children.add(child);
            section.setChildren(children);
            session.persist(child);

        }
    }
}
