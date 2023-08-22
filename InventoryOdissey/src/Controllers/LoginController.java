package Controllers;



import DataBase.DBController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public boolean login(String usuario, String contrasena) {
        try (Connection connection = DBController.getConnection()) {
            String query = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}