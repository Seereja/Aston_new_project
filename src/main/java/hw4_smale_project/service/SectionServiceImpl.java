package hw4_smale_project.service;

import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;
import hw4_smale_project.repository.SectionDAOImp;
import hw4_smale_project.service.serviceAbstract.SectionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class SectionServiceImpl implements SectionService {

    private final SectionDAOImp sectionDAOImp;


    public SectionServiceImpl(SectionDAOImp sectionDAO) {
        this.sectionDAOImp = sectionDAO;
    }

    public SectionServiceImpl() {
        this.sectionDAOImp = new SectionDAOImp();
    }

    @Override
    @Transactional
    public Section findSectionByTeacherId(int id) {
        return sectionDAOImp.findSectionByTeacherId(id);
    }

    @Override
    @Transactional
    public List<Section> getAllSection() throws SQLException {
        List<Section> sections = sectionDAOImp.getAllSection();
        sections.stream().map(Section::getName).forEach(System.out::println);
        return sections;
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

    @Override
    public void saveChildInSection(Child child) {
        sectionDAOImp.saveChildInSection(child);
    }

}
