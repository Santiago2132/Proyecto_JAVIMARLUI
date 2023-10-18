package Model;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Proveedor {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    /*MÉTODOS*/

    public int agregarProveedor(String nombre, String nombreEmpresa, int nitEmpresa, String telefono, String email, int tipo) {
        int resultado = 0;
        Connection conexion = null;
        String query = "INSERT INTO PROVEEDOR (NOMBRE, NOMBRE_EMPRESA, NIT_EMPRESA, TELEFONO, EMAIL, TIPO) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.setString(2, nombreEmpresa);
            pstmt.setInt(3, nitEmpresa);
            pstmt.setString(4, telefono);
            pstmt.setString(5, email);
            pstmt.setInt(6, tipo);
            resultado = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Proveedor agregado correctamente.");
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int eliminarProveedor(int idProveedor) {
        int resultado = 0;
        Connection conexion = null;
        String query = "DELETE FROM PROVEEDOR WHERE ID_PROVEEDOR = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idProveedor);
            resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún proveedor con ese ID.");
            }

            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int modificarProveedor(int idProveedor, String nuevoNombre, String nuevoTelefono, String nuevoEmail, int nuevoTipo) {
        int resultado = 0;
        Connection conexion = null;
        String query = "UPDATE PROVEEDOR SET NOMBRE = ?, TELEFONO = ?, EMAIL = ?, TIPO = ? WHERE ID_PROVEEDOR = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoTelefono);
            pstmt.setString(3, nuevoEmail);
            pstmt.setInt(4, nuevoTipo);
            pstmt.setInt(5, idProveedor);
            resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún proveedor con ese ID.");
            }

            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String[] args) {
        Proveedor proveedor = new Proveedor();
        int resultadoAgregar = proveedor.agregarProveedor("Santiago Pico", "Natura", 123456789, "123-456-7890", "santiago@gmail.com", 1);
        //int resultadoEliminar = proveedor.eliminarProveedor(2);
        //int resultadoMofificar = proveedor.modificarProveedor(1, "Santiago Pico", "123-456-7890", "santiagoPico@gmail.com", 2);
    }
}
