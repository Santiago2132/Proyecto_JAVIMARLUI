package Model;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
public class DetalleEmpresa {
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

    public int agregarDetalleEmpresa(int nitEmpresa,String nombre, Blob logo, String direccion, String telefono) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "INSERT INTO DETALLE_EMPRESA (NIT_EMPRESA,NOMBRE, LOGO, DIRECCION, TELEFONO) VALUES (?, ?, ?, ?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, nitEmpresa);
            pstmt.setString(2, nombre);
            pstmt.setBlob(3, logo);
            pstmt.setString(4, direccion);
            pstmt.setString(5, telefono);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Detalle de empresa agregado correctamente.");
                // Obtener el NIT de la empresa recién insertada
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resultado = generatedKeys.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el detalle de empresa.");
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

    public int eliminarDetalleEmpresa(int nitEmpresa) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "DELETE FROM DETALLE_EMPRESA WHERE NIT_EMPRESA = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, nitEmpresa);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Detalle de empresa eliminado correctamente.");
                resultado = 1;  // Indica que se eliminó con éxito
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el detalle de empresa.");
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

    public int modificarDetalleEmpresa(int nitEmpresa, String nombre, Blob logo, String direccion, String telefono) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "UPDATE DETALLE_EMPRESA SET NOMBRE = ?, LOGO = ?, DIRECCION = ?, TELEFONO = ? WHERE NIT_EMPRESA = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.setBlob(2, logo);
            pstmt.setString(3, direccion);
            pstmt.setString(4, telefono);
            pstmt.setInt(5, nitEmpresa);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Detalle de empresa modificado correctamente.");
                resultado = 1;  // Indica que se modificó con éxito
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el detalle de empresa.");
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

    public static void main (String[] args) throws SQLException, IOException {
        String rutaImagen = "src/UI/IMAGE NOT FOUND.jpg";
        Blob imagen = obtenerImagen(rutaImagen);
        DetalleEmpresa detalleEmpresa = new DetalleEmpresa();
        int resultadoAgregar = detalleEmpresa.agregarDetalleEmpresa(1, "Bonita", imagen, "Callejuelas", "3152465875");
        //int resultadoEliminar = detalleEmpresa.eliminarDetalleEmpresa(1);
        //int resultadoModificar = detalleEmpresa.modificarDetalleEmpresa(1, "Bonita1", imagen, "Callejuelas Apto", "3152460587");
    }
}
