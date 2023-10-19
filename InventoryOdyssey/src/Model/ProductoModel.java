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

    public int agregarProducto(double precio, int cantidad, Blob imagen, double iva) {
        int resultado = 0;
        Connection conexion = null;
        String query = "INSERT INTO PRODUCTO (PRECIO, CANTIDAD, IMAGEN, IVA) VALUES (?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setDouble(1, precio);
            pstmt.setInt(2, cantidad);
            pstmt.setBlob(3, imagen);
            pstmt.setDouble(4, iva);
            resultado = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }public boolean agregarProducto(double precio, int cantidad, double iva) {
        boolean resultado = false;
        Connection conexion = null;
        String query = "INSERT INTO PRODUCTO (PRECIO, CANTIDAD, IMAGEN, IVA) VALUES (?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setDouble(1, precio);
            pstmt.setInt(2, cantidad);
            // Obtener la imagen desde una ruta predeterminada en caso de que no esté disponible
            String rutaImagen = "src/UI/IMAGE NOT FOUND.jpg";
            Blob imagen = obtenerImagen(rutaImagen);
            pstmt.setBlob(3, imagen);
            pstmt.setDouble(4, iva);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                resultado = true;
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
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

    //metodo para modificar el producto por precio, el iva, la cantidad, pero que el iva y cantidad sea opcional si el usuario lo desea
    public int modificarProducto(int idProducto, int nuevaCantidad, double nuevoPrecio, Double nuevoIva) {
        int resultado = 0;
        Connection conexion = null;
        String query;
        if (nuevoIva != null) {
            // Si se proporciona un nuevo valor de IVA, actualiza también el IVA
            query = "UPDATE PRODUCTO SET PRECIO = ?, CANTIDAD = ?, IVA = ? WHERE ID_PRODUCTO = ?";
        } else {
            // Si no se proporciona un valor de IVA, solo actualiza el precio
            query = "UPDATE PRODUCTO SET PRECIO = ? WHERE ID_PRODUCTO = ?";
        }
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setDouble(1, nuevoPrecio);
            if (nuevoIva != null) {
                pstmt.setInt(2, nuevaCantidad);
                pstmt.setDouble(3, nuevoIva);
                pstmt.setInt(4, idProducto);
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
        boolean resultadoAgregar = producto.agregarProducto(49.99, 20, 0.19);
        //int resultadoEliminar = producto.eliminarProducto(1);
        // int resultadoModificar = producto.modificarProducto(1, 2 ,20.00, 0.19);
    }
}