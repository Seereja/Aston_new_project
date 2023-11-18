package hw4_smale_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
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
    private int age;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Role> roles;

    public User(String name, String surname, String email, int phone, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public User() {

    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }
}
