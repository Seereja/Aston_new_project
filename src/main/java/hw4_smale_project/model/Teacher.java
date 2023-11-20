package hw4_smale_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends User {
    @Column(name = "category")
    private String category;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;



    public Teacher() {

    }

    public Teacher(String category, Section section) {
        this.category = category;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "category=" + category +
                ", section=" + section +
//                ", user=" + user +
                '}';
    }
}
