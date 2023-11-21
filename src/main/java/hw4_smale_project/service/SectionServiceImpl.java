package hw4_smale_project.service;

import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;
import hw4_smale_project.repository.SectionDAOImp;
import hw4_smale_project.service.serviceAbstract.SectionService;

import java.sql.SQLException;
import java.util.List;

public class SectionServiceImpl implements SectionService {

    private final SectionDAOImp sectionDAOImp;


    public SectionServiceImpl(SectionDAOImp sectionDAO) {
        this.sectionDAOImp = sectionDAO;
    }

    public SectionServiceImpl() {
        this.sectionDAOImp = new SectionDAOImp();
    }

    @Override
    public Section findSectionByTeacherId(int id) {
        return sectionDAOImp.findSectionByTeacherId(id);
    }

    @Override
    public List<Section> getAllSection() throws SQLException {
        List<Section> sections = sectionDAOImp.getAllSection();
        sections.stream().map(Section::getSectionName).forEach(System.out::println);
        return sections;
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

    @Override
    public void saveChildInSection(Child child) {
        sectionDAOImp.saveChildInSection(child);
    }

}
