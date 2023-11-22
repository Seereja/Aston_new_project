package hw4_smale_project.mapperInterface;

import hw4_smale_project.DTO.ChildDTO;
import hw4_smale_project.DTO.TeacherDTO;
import hw4_smale_project.model.Child;
import hw4_smale_project.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherModelMapper {
    TeacherModelMapper INSTANCE = Mappers.getMapper(TeacherModelMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "age", target = "age")
    TeacherDTO toDTO(Teacher teacher);
}
