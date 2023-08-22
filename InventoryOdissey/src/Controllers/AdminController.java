package Controllers;

import DataBase.DBController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminController {
    public void agregarUsuario(String nombre, String usuario, String contrasena, String tipoUsuario) {
        try (Connection connection = DBController.getConnection()) {
            String query = "INSERT INTO usuarios (nombre, usuario, contrasena, tipo_usuario) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, usuario);
            statement.setString(3, contrasena);
            statement.setString(4, tipoUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
