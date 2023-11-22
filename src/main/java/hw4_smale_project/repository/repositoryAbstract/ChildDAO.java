package hw4_smale_project.repository.repositoryAbstract;


import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.User;

import java.util.List;

public interface ChildDAO {
    public List<ChildDTO> getAllChildren();

    public List<Child> getAllChildrenAndSection();

    void saveChildren(User user);

    ChildDTO getChildById(int id);

    void deleteChildren(int id);

    List<ChildDTO> getChildrenBySectionId(int id) throws ClassNotFoundException;

}
