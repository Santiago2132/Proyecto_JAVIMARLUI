package Controllers;

import DataBase.DBController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorController {
    public ResultSet obtenerClientes() {
        try (Connection connection = DBController.getConnection()) {
            String query = "SELECT * FROM clientes";
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}