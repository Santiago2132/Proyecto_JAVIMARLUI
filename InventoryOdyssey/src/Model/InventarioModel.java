package Model;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    /*MÉTODOS*/

    public int agregarEnInventario(int productoId, int proveedorId,String nombre, String categoria, int cantidadStock, double precioCompra, String descripcion) {
        int resultado = 0;
        Connection conexion = null;
        String query = "INSERT INTO INVENTARIO (PRODUCTO_ID_PRODUCTO, PROVEEDOR_ID_PROVEEDOR, NOMBRE, CATEGORIA, CANTIDAD_STOCK, PRECIO_COMPRA, DESCRIPCION) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, productoId);
            pstmt.setInt(2, proveedorId);
            pstmt.setString(3, nombre);
            pstmt.setString(4, categoria);
            pstmt.setInt(5, cantidadStock);
            pstmt.setDouble(6, precioCompra);
            pstmt.setString(7, descripcion);
            resultado = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto agregado correctamente.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int eliminarDeInventario(int productoId) {
        int resultado = 0;
        Connection conexion = null;
        String query = "DELETE FROM INVENTARIO WHERE PRODUCTO_ID_PRODUCTO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, productoId);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado del inventario correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto en el inventario con ese ID.");
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int modificarEnInventario(int productoId, int nuevaCantidadStock, Double nuevoPrecioCompra) {
        int resultado = 0;
        Connection conexion = null;
        String query;
        if (nuevoPrecioCompra != null) {
            // Si se proporciona un nuevo valor de precio de compra, actualiza también el precio de compra
            query = "UPDATE INVENTARIO SET CANTIDAD_STOCK = ?, PRECIO_COMPRA = ? WHERE PRODUCTO_ID_PRODUCTO = ?";
        } else {
            // Si no se proporciona un valor de precio de compra, solo actualiza la cantidad de stock
            query = "UPDATE INVENTARIO SET CANTIDAD_STOCK = ? WHERE PRODUCTO_ID_PRODUCTO = ?";
        }
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, nuevaCantidadStock);
            if (nuevoPrecioCompra != null) {
                pstmt.setDouble(2, nuevoPrecioCompra);
                pstmt.setInt(3, productoId);
            } else {
                pstmt.setInt(2, productoId);
            }
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado en el inventario correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto en el inventario con ese ID.");
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /*MÉTODOS NECESARIOS*/

    static class InformacionInventario {
        private int idInventario;
        private String nombre;
        private double precioCompra;
        private int cantidadStock;

        public InformacionInventario(int idInventario, int idProveedor, String nombre, double precioCompra, int cantidadStock) {
            this.idInventario = idInventario;
            this.nombre = nombre;
            this.precioCompra = precioCompra;
            this.cantidadStock = cantidadStock;
        }

        public int getIdInventario() {
            return idInventario;
        }

        public int getIdProveedor() {
            return idInventario;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecioCompra() {
            return precioCompra;
        }

        public int getCantidadStock() {
            return cantidadStock;
        }
    }

    //MÉTODO PARA RECORRER LA INFORMACIÓN DEL INVENTARIO
    public static List<InformacionInventario> obtenerInformacionInventario() {
        List<InformacionInventario> informacionInventario = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "SELECT ID_INVENTARIO, PROVEEDOR_ID_PROVEEDOR, NOMBRE, PRECIO_COMPRA, CANTIDAD_STOCK FROM INVENTARIO";

        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idInventario = rs.getInt("ID_INVENTARIO");
                int idProveedor = rs.getInt("PROVEEDOR_ID_PROVEEDOR");
                String nombre = rs.getString("NOMBRE");
                double precioCompra = rs.getDouble("PRECIO_COMPRA");
                int cantidadStock = rs.getInt("CANTIDAD_STOCK");

                InformacionInventario info = new InformacionInventario(idInventario, idProveedor, nombre, precioCompra, cantidadStock);
                informacionInventario.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return informacionInventario;
    }

    public static void main (String[] args){
        InventarioModel inventario = new InventarioModel();
        int resultadoAgregar = inventario.agregarEnInventario(1, 1, "Puntilla", "Tornillos y adhesivos", 10, 15.00, "Puntilla Con Cabeza 3pg 500g" );
        //int resultadoEliminar = inventario.eliminarDeInventario(1);
        //int resultadoModificar = inventario.modificarEnInventario(1, 9, 75.00);

        // Llama al método para obtener la información del inventario
        /*List<InformacionInventario> informacion = inventario.obtenerInformacionInventario();
        // Itera a través de la lista de InformacionInventario y muestra la información
        for (InformacionInventario info : informacion) {
            System.out.println("ID Inventario: " + info.getIdInventario());
            System.out.println("ID Proveedor: " + info.getIdProveedor());
            System.out.println("Nombre: " + info.getNombre());
            System.out.println("Precio de Compra: " + info.getPrecioCompra());
            System.out.println("Cantidad en Stock: " + info.getCantidadStock());
            System.out.println();
        }*/
    }
}