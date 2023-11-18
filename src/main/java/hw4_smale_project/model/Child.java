package hw4_smale_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "children")
public class Child extends User {
    @Column(name = "categoryInSports")
    private String categoryInSports;
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "children_section",
            //связь с таблицей child
            joinColumns = @JoinColumn(name = "child_id"),
            //связь с таблицей Section
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public String getCategoryInSports() {
        return categoryInSports;
    }

    public void setCategoryInSports(String categoryInSports) {
        this.categoryInSports = categoryInSports;
    }
}
