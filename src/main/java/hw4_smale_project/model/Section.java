package hw4_smale_project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section extends GenericModel {

    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "sections")
    private List<Child> children;

    @OneToMany(mappedBy = "section")
    private List<Teacher> teachers;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
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

        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", teachers=" + teachers +
                '}';
    }
}
