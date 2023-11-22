package hw4_smale_project.repository.repositoryAbstract;

import hw4_smale_project.DTO.SectionDTO;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.Section;

import java.sql.SQLException;
import java.util.List;

public interface SectionDAO {

    public SectionDTO findSectionByTeacherId(int id);

    public List<SectionDTO> getAllSection() throws SQLException;

    void saveSection(Section section);

    SectionDTO getSectionById(int id);

    void deleteSectionById(int id);

}
