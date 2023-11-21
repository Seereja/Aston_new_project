package hw4_smale_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

}
