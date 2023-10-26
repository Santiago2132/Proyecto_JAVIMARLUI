package Model;
import java.sql.*;
import javax.swing.JOptionPane;
public class MetodoPago {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    public int agregarMetodoPago(int idmetodoPago, int idBanco, int tipoPago, String descripcion) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "INSERT INTO METODO_PAGO (ID_METODO_PAGO, BANCO_NIT_BANCO, TIPO_PAGO, DESCRIPCION) VALUES (?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idmetodoPago);
            pstmt.setInt(2, idBanco);
            pstmt.setInt(3, tipoPago);
            pstmt.setString(4, descripcion);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Método de pago agregado correctamente.");
                // Obtener el ID del método de pago recién insertado
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resultado = generatedKeys.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el método de pago.");
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

    public int eliminarMetodoPago(int idMetodoPago) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "DELETE FROM METODO_PAGO WHERE ID_METODO_PAGO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idMetodoPago);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Método de pago eliminado correctamente.");
                resultado = idMetodoPago;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el método de pago.");
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

    public int modificarMetodoPago(int idMetodoPago, int idBanco, int tipoPago, String descripcion) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "UPDATE METODO_PAGO SET BANCO_NIT_BANCO = ?, TIPO_PAGO = ?, DESCRIPCION = ? WHERE ID_METODO_PAGO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idBanco);
            pstmt.setInt(2, tipoPago);
            pstmt.setString(3, descripcion);
            pstmt.setInt(4, idMetodoPago);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Método de pago modificado correctamente.");
                resultado = idMetodoPago;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el método de pago.");
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
        MetodoPago metodoPago = new MetodoPago();
        int resultadoAgregar = metodoPago.agregarMetodoPago(1,1,1,  "3 Coutas");
        //int resultadoEliminar = metodoPago.eliminarMetodoPago(1);
        //int resultadoModificar = metodoPago.modificarMetodoPago(1, 1, 1, "2 Coutas");
    }

}
