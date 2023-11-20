package hw4_smale_project.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sections")
public class Section extends GenericModel {

    @Column(name = "section_name")
    private String sectionName;

    @ManyToMany(mappedBy = "sections")
    private Set<Child> children = new HashSet<>();
    @OneToMany(mappedBy = "section")
    private List<Teacher> teachers;


    public Section(String sectionName, Set<Child> children, List<Teacher> teachers) {
        this.sectionName = sectionName;
        this.children = children;
        this.teachers = teachers;
    }


    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Section() {

    }

    public Section(String name) {

        this.sectionName = name;
    }


    public String getName() {
        return sectionName;
    }

    public void setName(String name) {
        this.sectionName = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + sectionName + '\'' +
                ", children=" + children +
                ", teachers=" + teachers +
                '}';
    }
}
