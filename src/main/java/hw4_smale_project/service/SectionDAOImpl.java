package hw4_smale_project.service;

import hw4_smale_project.model.Section;
import hw4_smale_project.repository.SectionDAOImp;
import jakarta.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;

public class SectionDAOImpl implements SectionService {

    private final SectionDAOImp sectionDAOImp;


    public SectionDAOImpl(SectionDAOImp sectionDAO) {
        this.sectionDAOImp = sectionDAO;
    }

    @Override
    @Transactional
    public Section findSectionByTeacherId(int id) {
        return sectionDAOImp.findSectionByTeacherId(id);
    }

    @Override
    @Transactional

    public List<Section> getAllSection() throws SQLException {
        return sectionDAOImp.getAllSection();
    }

    @Override
    @Transactional

    public void saveSection(Section section) {
        sectionDAOImp.saveSection(section);
    }

    @Override
    @Transactional

    public Section getSectionById(int id) {
        return sectionDAOImp.getSectionById(id);
    }

    @Override
    @Transactional

    public void deleteSectionById(int id) {
        sectionDAOImp.deleteSectionById(id);
    }

}
