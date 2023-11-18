package hw4_smale_project.service;

import hw4_smale_project.model.Section;
import hw4_smale_project.repository.SectionDAO;

import java.sql.SQLException;

public class SectionDAOImpl {

    private final SectionDAO sectionDAO;


    public SectionDAOImpl(SectionDAO sectionDAO) {
        this.sectionDAO = sectionDAO;
    }


    public Section findSectionByTeacherId(int id) {
        Section section = new Section();

        try {
            section = sectionDAO.findSectionByTeacherId(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(section);
        return section;
    }
}
