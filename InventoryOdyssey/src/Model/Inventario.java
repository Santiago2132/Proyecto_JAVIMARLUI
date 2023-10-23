package Model;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    public static BaseDatos conexion = new BaseDatos();
    public static PreparedStatement pstmt;
    public static ResultSet resultado;
    public static String mysql;

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

    public int agregarEnInventario(int idProveedor, int idProducto, String nombre, Blob imagen, String categoria, int cantidadStock, double precioCompra, double precioVenta, double iva, String descripcion) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "INSERT INTO INVENTARIO (PROVEEDOR_ID_PROVEEDOR, ID_PRODUCTO, NOMBRE, IMAGEN, CATEGORIA, CANTIDAD_STOCK, PRECIO_COMPRA, PRECIO_VENTA, IVA, DESCRIPCION) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idProveedor);
            pstmt.setInt(2, idProducto);
            pstmt.setString(3, nombre);
            pstmt.setBlob(4, imagen);
            pstmt.setString(5, categoria);
            pstmt.setInt(6, cantidadStock);
            pstmt.setDouble(7, precioCompra);
            pstmt.setDouble(8, precioVenta);
            pstmt.setDouble(9, iva);
            pstmt.setString(10, descripcion);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Inventario agregado correctamente.");
                // Obtener el ID de inventario recién insertado
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resultado = generatedKeys.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el inventario.");
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

    public static void main (String[] args) throws SQLException, IOException {
        String rutaImagen = "src/UI/IMAGE NOT FOUND.jpg";
        Blob imagen = obtenerImagen(rutaImagen);
        Inventario inventario = new Inventario();
        int resultadoAgregar = inventario.agregarEnInventario(1, 1, "Puntilla", imagen, "Tornillos y adhesivos", 10, 15.00, 30.00, 0.19, "Puntilla Con Cabeza 3pg 500g" );
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