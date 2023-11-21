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
@MappedSuperclass
public abstract class GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generic_model_seq")
    @SequenceGenerator(name = "generic_model_seq", sequenceName = "generic_model_seq")
    @Column(name = "id", nullable = false)
    private Long id;

}
