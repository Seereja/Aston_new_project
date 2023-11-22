package hw4_smale_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sections")
public class Section extends GenericModel {

    @Column(name = "section_name")
    private String sectionName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "sections")
    private Set<Child> children = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private List<Teacher> teachers;

    @Override
    public String toString() {
        return "Section{" +
                "sectionName='" + sectionName;
    }


    //    @Override
//    public String toString() {
//        return "Section{" +
//                "name='" + sectionName + '\'' +
//                ", children=" + children +
//                ", teachers=" + teachers +
//                '}';
//    }
}
