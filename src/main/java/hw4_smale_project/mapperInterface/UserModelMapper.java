package hw4_smale_project.mapperInterface;

import hw4_smale_project.DTO.UserDTO;
import hw4_smale_project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserModelMapper {
    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "age", target = "age")
    UserDTO toUserDTO(User user);
}
