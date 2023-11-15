package hw2_smale_project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class childrenMapper {
    public  toBooking(ResultSet resultSet) throws SQLException {
        Booking booking = new Booking();
        booking.setId(resultSet.getLong("id"));
        booking.setName(resultSet.getString("name"));
        booking.setSurname(resultSet.getString("surname"));
        booking.setDeparture_from(resultSet.getString("departure_from"));
        booking.setArriving_to(resultSet.getString("arriving_to"));
        booking.setPrice(resultSet.getInt("price"));
        return booking;
    }
}
