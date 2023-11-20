package hw4_smale_project.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child extends User {
    @Column(name = "categoryInSports")
    private String categoryInSports;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,})
    @JoinTable(name = "children_section",
            joinColumns = @JoinColumn(name = "child_id"),
            foreignKey = @ForeignKey(name = "FK_CHILDREN_SECTIONS"),
            inverseJoinColumns = @JoinColumn(name = "section_id"),
            inverseForeignKey = @ForeignKey(name = "FK_SECTIONS_CHILDREN"))
    private Set<Section> sections;


    public Child() {

    }

    public Child(String name, String surname, String email, int phone, int age, String categoryInSports, Set<Section> sections, User user) {
        this.categoryInSports = categoryInSports;
        this.sections = sections;
    }

    public Child(String categoryInSports, User user) {
        this.categoryInSports = categoryInSports;
    }

    public Child(String categoryInSports, Set<Section> sections, User user) {
        this.categoryInSports = categoryInSports;
        this.sections = sections;
    }

    public String getCategoryInSports() {
        return categoryInSports;
    }

    public void setCategoryInSports(String categoryInSports) {
        this.categoryInSports = categoryInSports;
    }

    @Override
    public String toString() {
        return "Child{" +
                "categoryInSports='" + categoryInSports + '\'' +
                ", sections=" + sections +
                '}';
    }
}
