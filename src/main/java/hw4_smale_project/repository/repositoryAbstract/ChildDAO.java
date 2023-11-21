package hw4_smale_project.repository.repositoryAbstract;


import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.DTO.ChildSectionDTO;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;

import java.util.List;

public interface ChildDAO {
    public List<ChildDTO> getAllChildren();

    public List<Child> getAllChildrenAndSection();

    void saveChildren(User user);

    Child getChildren(int id);

    void deleteChildren(int id);

    List<ChildSectionDTO> getChildrenBySectionId(int id) throws ClassNotFoundException;

    public void addChildrenToSection(Child child);
}
