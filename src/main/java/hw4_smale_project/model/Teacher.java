package hw4_smale_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher extends User {
    @Column(name = "category")
    private String category;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "category=" + category +
//                ", section=" + section +
//                '}';
//    }
}
