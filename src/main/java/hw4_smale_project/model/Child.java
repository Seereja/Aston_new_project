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
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;


    public Child() {

    }

    public Child(String name, String surname, String email, int phone, int age, String categoryInSports, List<Section> sections, User user) {
//        super(name, surname, email, phone, age);
        this.categoryInSports = categoryInSports;
        this.sections = sections;
//        this.user = user;
    }

    public Child(String categoryInSports, User user) {
        this.categoryInSports = categoryInSports;
//        this.user = user;
    }

    public Child(String categoryInSports, List<Section> sections, User user) {
        this.categoryInSports = categoryInSports;
        this.sections = sections;
//        this.user = user;
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
//                ", user=" + user +
                '}';
    }
}
