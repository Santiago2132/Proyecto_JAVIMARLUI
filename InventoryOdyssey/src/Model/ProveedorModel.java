package Model;
import java.sql.*;
import javax.swing.JOptionPane;
public class ProveedorModel {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    /*MÉTODOS*/

    public int agregarProveedor(int idProveedor, String nombre, String nombreEmpresa, int nitEmpresa, String telefono, String email, int tipo) {
        int resultado = 0;
        Connection conexion = null;
        String query = "INSERT INTO PROVEEDOR (ID_PROVEEDOR, NOMBRE, NOMBRE_EMPRESA, NIT_EMPRESA, TELEFONO, EMAIL, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idProveedor);
            pstmt.setString(2, nombre);
            pstmt.setString(3, nombreEmpresa);
            pstmt.setInt(4, nitEmpresa);
            pstmt.setString(5, telefono);
            pstmt.setString(6, email);
            pstmt.setInt(7, tipo);
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
        ProveedorModel proveedor = new ProveedorModel();
        int resultadoAgregar = proveedor.agregarProveedor(1,"Santiago Pico", "Natura", 123456789, "123-456-7890", "santiago@gmail.com", 1);
        //int resultadoEliminar = proveedor.eliminarProveedor(2);
        //int resultadoMofificar = proveedor.modificarProveedor(1, "Santiago Pico", "123-456-7890", "santiagoPico@gmail.com", 2);
    }
}