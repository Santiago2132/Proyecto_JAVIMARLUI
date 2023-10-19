package Model;

import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FacturaModel {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    /*MÉTODOS A PARTE*/

    // Método para obtener la fecha actual
    public Date obtenerFechaActual() {
        long currentTime = System.currentTimeMillis();
        return new Date(currentTime);
    }

    // Método para calcular la fecha de vencimiento basada en la fecha de emisión y agregar 2 meses
    public Date calcularFechaVencimiento(Date fechaEmision) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fechaEmision);
        calendar.add(Calendar.MONTH, 2); // Agregar 2 meses a la fecha de emisión
        long time = calendar.getTimeInMillis();
        return new Date(time);
    }

    public int agregarFactura(int clienteId, int metodoPagoId, int detalleEmpresaNit, int inventarioId, int productoId,
                              Date fechaEmision, Date fechaVence, double impuestos, Double descuento, double total) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "INSERT INTO FACTURA (CLIENTE_ID_CLIENTE, METODO_PAGO_ID_METODO_PAGO, DETALLE_EMPRESA_NIT_EMPRESA, " +
                "INVENTARIO_ID_INVENTARIO, INVENTARIO_PRODUCTO_ID_PRODUCTO, FECHA_EMISION, FECHA_VENCE, IMPUESTOS, DESCUENTO, TOTAL) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, clienteId);
            pstmt.setInt(2, metodoPagoId);
            pstmt.setInt(3, detalleEmpresaNit);
            pstmt.setInt(4, inventarioId);
            pstmt.setInt(5, productoId);
            pstmt.setDate(6, fechaEmision);
            pstmt.setDate(7, fechaVence);
            pstmt.setDouble(8, impuestos);
            if (descuento != null) {
                pstmt.setDouble(9, descuento);
            } else {
                pstmt.setNull(9, java.sql.Types.DOUBLE); // Establecer DESCUENTO a NULL si no se proporciona
            }
            pstmt.setDouble(10, total);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Factura agregada correctamente.");
                // Obtener el ID de la factura recién insertada
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resultado = generatedKeys.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar la factura.");
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

    /*IMPORTANTE*/
    // Método para modificar no necesario aún

    // Método de elimanar factura
    public int eliminarFactura(int idFactura) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "DELETE FROM FACTURA WHERE ID_FACTURA = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idFactura);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Factura eliminada correctamente.");
                resultado = idFactura; // Devolver el ID de la factura eliminada
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la factura.");
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
        FacturaModel factura = new FacturaModel();
        int resultadoAgregar = factura.agregarFactura(1,1, 1, 1, 1, factura.obtenerFechaActual(), factura.calcularFechaVencimiento(factura.obtenerFechaActual()), 0.19, 0.10, 150.000);
        //int resultadoEliminar = factura.eliminarFactura(1);
    }
}
