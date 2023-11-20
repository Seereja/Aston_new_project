package hw4_smale_project.service;

import hw4_smale_project.model.Section;
import hw4_smale_project.repository.SectionDAOImp;

import java.sql.SQLException;
import java.util.List;

public class SectionDAOImpl implements SectionService {

    private final SectionDAOImp sectionDAOImp;


    public SectionDAOImpl(SectionDAOImp sectionDAO) {
        this.sectionDAOImp = sectionDAO;
    }

    @Override
    public Section findSectionByTeacherId(int id) {
        return sectionDAOImp.findSectionByTeacherId(id);
    }

    @Override
    public List<Section> getAllSection() throws SQLException {
        return sectionDAOImp.getAllSection();
    }

    @Override
    public void saveSection(Section section) {
        sectionDAOImp.saveSection(section);
    }

    @Override
    public Section getSectionById(int id) {
        return sectionDAOImp.getSectionById(id);
    }

    @Override
    public void deleteSectionById(int id) {
        sectionDAOImp.deleteSectionById(id);
    }


//    public Section findSectionByTeacherId(int id) {
//        Section section = new Section();
//
//        try {
//            section = sectionDAO.findSectionByTeacherId(id);
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(section);
//        return section;
//    }
}
