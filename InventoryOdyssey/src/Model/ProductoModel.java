package Model;
import Classes.Producto;

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
    public static Blob obtenerImagen(String rutaImagen) throws IOException, SQLException {
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imagen, "jpg", baos);
        baos.flush();
        byte[] bytesDeImagen = baos.toByteArray();
        baos.close();
        // Convierte el array de bytes en un objeto Blob
        Blob imagenBlob = new SerialBlob(bytesDeImagen);
        return imagenBlob;
    }

    /*MÉTODOS*/

    public int agregarProducto(double precio, Blob imagen, double iva) {
        int resultado = 0;
        Connection conexion = null;
        String query = "INSERT INTO PRODUCTO (PRECIO, IMAGEN, IVA) VALUES (?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setDouble(1, precio);
            pstmt.setBlob(2, imagen);
            pstmt.setDouble(3, iva);
            resultado = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int eliminarProducto(int idProducto) {
        int resultado = 0;
        Connection conexion = null;
        String query = "DELETE FROM PRODUCTO WHERE ID_PRODUCTO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idProducto);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto con ese ID.");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    //metodo para modificar el producto por precio y el iva, pero que el iva sea opcional si el usuario lo desea
    public int modificarProducto(int idProducto, double nuevoPrecio, Double nuevoIva) {
        int resultado = 0;
        Connection conexion = null;
        String query;
        if (nuevoIva != null) {
            // Si se proporciona un nuevo valor de IVA, actualiza también el IVA
            query = "UPDATE PRODUCTO SET PRECIO = ?, IVA = ? WHERE ID_PRODUCTO = ?";
        } else {
            // Si no se proporciona un valor de IVA, solo actualiza el precio
            query = "UPDATE PRODUCTO SET PRECIO = ? WHERE ID_PRODUCTO = ?";
        }
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setDouble(1, nuevoPrecio);
            if (nuevoIva != null) {
                pstmt.setDouble(2, nuevoIva);
                pstmt.setInt(3, idProducto);
            } else {
                pstmt.setInt(2, idProducto);
            }
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto con ese ID.");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }



    public static void main (String[] args) throws IOException, SQLException {
        String rutaImagen = "src/UI/IMAGE NOT FOUND.jpg";
        Blob imagen = obtenerImagen(rutaImagen);
        ProductoModel producto = new ProductoModel();
        //int resultadoAgregar = producto.agregarProducto(19.99, imagen, 0.19);
        //int resultadoEliminar = producto.eliminarProducto(3);
        // int resultadoModificar = producto.modificarProducto(1, 20.00, 0.19);
    }
}