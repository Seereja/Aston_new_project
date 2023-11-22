package hw4_smale_project.mapperInterface;

import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.model.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ChildModelMapper {
    ChildModelMapper INSTANCE = Mappers.getMapper(ChildModelMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "categoryInSports", target = "categoryInSports")
    @Mapping(source = "age", target = "age")
    ChildDTO toDTO(Child child);
}
