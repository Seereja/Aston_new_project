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
public class SectionDTO {

    private Integer id;
    private String sectionName;

    @Override
    public String toString() {
        return "SectionDTO{" +
                "id=" + id +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
