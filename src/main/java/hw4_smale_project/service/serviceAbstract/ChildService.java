package hw4_smale_project.service.serviceAbstract;

import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.model.Child;

import java.sql.SQLException;
import java.util.List;

public interface ChildService {
    public List<ChildDTO> getAllChildren() throws SQLException;

    void saveChildren(Child child);

    ChildDTO getChildById(int id);

    void deleteChildren(int id);

    public List<Child> getAllChildrenAndSection();

    List<ChildDTO> getChildrenBySectionId(int id) throws ClassNotFoundException;
}
