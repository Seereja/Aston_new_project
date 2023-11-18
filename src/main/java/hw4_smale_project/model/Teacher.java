package hw4_smale_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends User {
    @Column(name = "category")
    private int category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
