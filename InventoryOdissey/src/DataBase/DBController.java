package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {
    private static final String URL = "jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1098630136";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}