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
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends GenericModel {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")

    private String surname;
    @Column(name = "email")

    private String email;
    @Column(name = "phone")

    private int phone;
    @Column(name = "age")
    private Integer age;

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", email='" + email + '\'' +
//                ", phone=" + phone +
//                ", age=" + age +
//                '}';
//    }
}
