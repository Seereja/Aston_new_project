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
    private Long id;
    private String sectionName;
    private List<ChildDTO> children;
    private List<TeacherDTO> teachers;
}
