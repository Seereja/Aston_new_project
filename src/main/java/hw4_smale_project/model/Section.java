package hw4_smale_project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section extends GenericModel {

    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "children_section",
            //связь с таблицей section
            joinColumns = @JoinColumn(name = "section_id"),
            //связь с таблицей child
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> children;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            mappedBy = "section",
            fetch = FetchType.LAZY)
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
                ", name='" + name + '\'' +
                '}';
    }
}
