package hw4_smale_project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
    private Long id;
    private String name;
    private String surname;
    private String categoryInSports;
    private int age;

    @Override
    public String toString() {
        return "ChildDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", categoryInSports='" + categoryInSports + '\'' +
                ", age=" + age +
                '}';
    }
}
