package Model;
import java.sql.*;
import javax.swing.JOptionPane;

public class Cliente {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    public int agregarCliente(String nombre, String identificacion, String direccion, String telefono, String email) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "INSERT INTO CLIENTE (NOMBRE, IDENTIFICACION, DIRECCION, TELEFONO, EMAIL) VALUES (?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nombre);
            pstmt.setString(2, identificacion);
            pstmt.setString(3, direccion);
            pstmt.setString(4, telefono);
            pstmt.setString(5, email);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
                // Obtener el ID del cliente recién insertado
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resultado = generatedKeys.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public int eliminarCliente(int identificacion) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = 0;
        String query = "DELETE FROM CLIENTE WHERE IDENTIFICACION = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, identificacion);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public int modificarCliente(int idCliente, String nuevoNombre, String nuevaIdentificacion, String nuevaDireccion, String nuevoTelefono, String nuevoEmail) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = 0;
        String query = "UPDATE CLIENTE SET NOMBRE = ?, IDENTIFICACION = ?, DIRECCION = ?, TELEFONO = ?, EMAIL = ? WHERE ID_CLIENTE = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaIdentificacion);
            pstmt.setString(3, nuevaDireccion);
            pstmt.setString(4, nuevoTelefono);
            pstmt.setString(5, nuevoEmail);
            pstmt.setInt(6, idCliente);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el cliente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public static void main (String[] args){
        Cliente cliente = new Cliente();
        int resultadoAgregar = cliente.agregarCliente("Santiago", "109861459", "Callejuelas", "3152467894", "santiago@gmail.com");
        //int resultadoEliminar = cliente.eliminarCliente(109861459);
        //int resultadoModificar = cliente.modificarCliente(1, "Santiago Maldonado","109861449", "Callejuelas Apto", "3152567894", "santiagoM@gmail.com" );
    }
}
