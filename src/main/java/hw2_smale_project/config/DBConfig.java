package hw2_smale_project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hw2_smale_project.DBConstants.*;

public class DBConfig {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_HOST = "localhost";
    private static final String DB_NAME = "children";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String PORT = "5432";

    public static Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection("jdbc:postgresql://"
                        + DB_HOST
                        + ":"
                        + PORT
                        + "/"
                        + DB_NAME,
                USER,
                PASSWORD);
    }

}
