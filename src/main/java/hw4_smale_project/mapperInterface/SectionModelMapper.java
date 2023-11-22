package hw4_smale_project.mapperInterface;

import hw4_smale_project.DTO.SectionDTO;
import hw4_smale_project.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionModelMapper {
    SectionModelMapper INSTANCE = Mappers.getMapper(SectionModelMapper.class);
    @Mapping(source = "id", target = "id")
    SectionDTO toDTO(Section section);
}
