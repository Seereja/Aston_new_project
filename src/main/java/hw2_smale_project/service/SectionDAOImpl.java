package hw2_smale_project.service;

import hw2_smale_project.config.DBConfig;
import hw2_smale_project.mapper.SectionMapper;
import hw2_smale_project.model.Section;
import hw2_smale_project.repository.SectionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionDAOImpl implements SectionDAO {

    private final DBConfig dbConfig;

    private final SectionMapper sectionMapper;

    public SectionDAOImpl(DBConfig dbConfig, SectionMapper sectionMapper) {
        this.dbConfig = dbConfig;
        this.sectionMapper = sectionMapper;
    }

    @Override
    public Section findSectionByTeacherId(int id) {
        Section section = new Section();
        try (Connection connection = DBConfig.connection()) {
            //получаем коннекшн
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT sections.id, sections.name " +
                            "FROM teachers " +
                            "JOIN sections ON teachers.section_id = sections.id " +
                            "WHERE teachers.id = ?;");
            preparedStatement.setInt(1, id);
            //получаем ресултсет
            ResultSet resultSet = preparedStatement.executeQuery();
            //достаем из резултсет
            while (resultSet.next()) {
                section = sectionMapper.toSectionOfString(resultSet);
                System.out.println(section);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return section;
    }
}
