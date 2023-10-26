package Model;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class ProductoModel {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    //Atributos//
    int incrementar = 0;

    /*Métodos a parte*/
    public int getIncrementar() {
        incrementar++;
        return incrementar;
    }
    public boolean agregarProducto(int idProducto, String nombre, double precio, int cantidad, double iva) {
        boolean exito = false;
        Connection conexion = null;
        String query = "INSERT INTO PRODUCTO (ID_PRODUCTO, NOMBRE, PRECIO_VENTA, CANTIDAD, IVA) VALUES (?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idProducto);
            pstmt.setString(2, nombre);
            pstmt.setDouble(3, precio);
            pstmt.setInt(4, cantidad);
            pstmt.setDouble(5, iva);
            int resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                exito = true;
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }

    public boolean modificarProducto(int idProducto, double nuevoPrecio, Integer nuevaCantidad, Double nuevoIva) {
        boolean exito = false;
        Connection conexion = null;
        String query;
        if (nuevaCantidad != null && nuevoIva != null) {
            query = "UPDATE PRODUCTO SET PRECIO_VENTA = ?, CANTIDAD = ?, IVA = ? WHERE ID_PRODUCTO = ?";
        } else if (nuevaCantidad != null) {
            query = "UPDATE PRODUCTO SET PRECIO_VENTA = ?, CANTIDAD = ? WHERE ID_PRODUCTO = ?";
        } else if (nuevoIva != null) {
            query = "UPDATE PRODUCTO SET PRECIO_VENTA = ?, IVA = ? WHERE ID_PRODUCTO = ?";
        } else {
            query = "UPDATE PRODUCTO SET PRECIO_VENTA = ? WHERE ID_PRODUCTO = ?";
        }
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setDouble(1, nuevoPrecio);
            if (nuevaCantidad != null && nuevoIva != null) {
                pstmt.setInt(2, nuevaCantidad);
                pstmt.setDouble(3, nuevoIva);
                pstmt.setInt(4, idProducto);
            } else if (nuevaCantidad != null) {
                pstmt.setInt(2, nuevaCantidad);
                pstmt.setInt(3, idProducto);
            } else if (nuevoIva != null) {
                pstmt.setDouble(2, nuevoIva);
                pstmt.setInt(3, idProducto);
            } else {
                pstmt.setInt(2, idProducto);
            }
            int resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                exito = true;
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }


    public static void main(String[] args) {
        ProductoModel productoModel = new ProductoModel();

        // Prueba agregarProducto
        boolean agregado = productoModel.agregarProducto(23,"Producto1", 50.0, 10, 0.12);
        System.out.println("Producto agregado: " + agregado);

        // Prueba modificarProducto
        boolean modificado = productoModel.modificarProducto(0, 60.0, null, null);
        System.out.println("Producto modificado: " + modificado);
    }
}