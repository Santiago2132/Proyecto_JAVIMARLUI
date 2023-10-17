package Model;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class Inventario {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

    /*MÉTODOS*/

    public int agregarEnInventario(int productoId, String nombre, String categoria, int cantidadStock, double precioCompra, String descripcion) {
        int resultado = 0;
        Connection conexion = null;
        String query = "INSERT INTO INVENTARIO (PRODUCTO_ID_PRODUCTO, NOMBRE, CATEGORIA, CANTIDAD_STOCK, PRECIO_COMPRA, DESCRIPCION) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, productoId);
            pstmt.setString(2, nombre);
            pstmt.setString(3, categoria);
            pstmt.setInt(4, cantidadStock);
            pstmt.setDouble(5, precioCompra);
            pstmt.setString(6, descripcion);
            resultado = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto agregado correctamente.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public static void main (String[] args){
        Inventario inventario = new Inventario();
        //int resultadoAgregar = inventario.agregarProducto(1, "Puntilla Con Cabeza 3pg 500g", "Tornillos y adhesivos", 10, 15.00, "Material:Hierro,Garantía:6Meses,PaísdeOrigen:Colombia,Meididas:3 pulgadas,Peso:0.515 Kg,TipodeCabeza:Otra." );
        int resultadoAgregar = inventario.agregarEnInventario(1, "Puntilla", "Tornillos y adhesivos", 10, 15.00, "Puntilla Con Cabeza 3pg 500g" );
    }
}
