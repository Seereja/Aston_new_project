package hw4_smale_project.service.serviceAbstract;

import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;

import java.sql.SQLException;
import java.util.List;

public interface SectionService {
    public Section findSectionByTeacherId(int id);

    public List<Section> getAllSection() throws SQLException;

    void saveSection(Section section);

    Section getSectionById(int id);

    void deleteSectionById(int id);
    void saveChildInSection(Child child);

}