package hw4_smale_project.mapperInterface;

import hw3_smale_project.model.Section;
import hw4_smale_project.DTO.SectionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionModelMapper {
    SectionModelMapper INSTANCE = Mappers.getMapper(SectionModelMapper.class);
    SectionDTO toDTO(Section section);
}
