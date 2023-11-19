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
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "category=" + category +
                ", section=" + section +
                ", user=" + user +
                '}';
    }
}
