package Model;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class Banco {
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

    public int agregarBanco(String nombre, Blob icono) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = -1;  // Valor por defecto en caso de fallo
        String query = "INSERT INTO BANCO (NOMBRE, ICONO) VALUES (?, ?)";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nombre);
            pstmt.setBlob(2, icono);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null,"Banco agregado correctamente.");
                // Obtener el ID del banco recién insertado
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resultado = generatedKeys.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo agregar el banco.");
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

    public int eliminarBanco(int idBanco) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = 0;
        String query = "DELETE FROM BANCO WHERE NIT_BANCO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idBanco);

            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Banco eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el banco.");
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

    public int modificarBanco(int idBanco, String nuevoNombre, Blob nuevoIcono) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        int resultado = 0;
        String query = "UPDATE BANCO SET NOMBRE = ?, ICONO = ? WHERE NIT_BANCO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nuevoNombre);
            pstmt.setBlob(2, nuevoIcono);
            pstmt.setInt(3, idBanco);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Banco modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el banco.");
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
        Banco banco = new Banco();
        //int resultadoAgregar = banco.agregarBanco("Bancolombia", imagen);
        //int resultadoEliminar = banco.eliminarBanco(1);
        //int resultadoModificar = banco.modificarBanco(1, "Banco de Colombia", imagen);

    }

}
