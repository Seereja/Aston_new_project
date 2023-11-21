package hw4_smale_project.service;

import hw4_smale_project.DTO.ChildSectionDTO;
import hw4_smale_project.model.Child;
import hw4_smale_project.repository.ChildDAOImp;
import hw4_smale_project.service.serviceAbstract.ChildService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildDAOImp childDAOImp;

    public ChildServiceImpl(ChildDAOImp childDAOImp) {
        this.childDAOImp = childDAOImp;

    }

    public ChildServiceImpl() {
        this.childDAOImp = new ChildDAOImp();

    }


    @Override
    @Transactional
    public List<Child> getAllChildren() throws SQLException {
        List<Child> children = childDAOImp.getAllChildren();
        children.stream().map(Child::getName).forEach(System.out::println);
        return children;
    }

    @Override
    @Transactional
    public void saveChildren(Child child) {
        childDAOImp.saveChildren(child);
    }

    @Override
    @Transactional
    public Child getChildren(int id) {
        return childDAOImp.getChildren(id);
    }

    @Override
    @Transactional
    public void deleteChildren(int id) {
        childDAOImp.deleteChildren(id);
    }

    @Override
    @Transactional
    public List<ChildSectionDTO> getChildrenBySectionId(int id) {
        List<ChildSectionDTO> children;
        children = childDAOImp.getChildrenBySectionId(3);
        children.forEach(System.out::println);
        return children;
    }

}

