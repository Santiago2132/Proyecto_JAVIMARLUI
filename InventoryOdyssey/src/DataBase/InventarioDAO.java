package DataBase;

import Classes.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/inventario";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1098630136";

    public InventarioDAO() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public  boolean existeUsuario(String nombreUsuario) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE nombre_usuario = ?")) {
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public  Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre_usuario = ?")) {
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("nombre_usuario"),rs.getString("password"), rs.getInt("tipoUsuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
