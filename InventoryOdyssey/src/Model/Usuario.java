package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Usuario {
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

    /*MÉTODOS*/

    public int agregarUsuario(String nombreCompleto, String nombreUsuario, String contrasena, String email, int rol){
        int resultado = 0;
        Connection conexion = null;
        //String query = "INSERT INTO USUARIO (ID_USUARIO, INVENTARIO_ID_INVENTARIO, NOMBRE_COMPLETO, NOMBRE_USUARIO, CONTRASENA, EMAIL, ROL) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String query = "INSERT INTO USUARIO (NOMBRE_COMPLETO, NOMBRE_USUARIO, CONTRASENA, EMAIL, ROL) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            //pstmt.setInt(2, inventarioId);
            pstmt.setString(1, nombreCompleto);
            pstmt.setString(2, nombreUsuario);
            pstmt.setString(3, contrasena);
            pstmt.setString(4, email);
            pstmt.setInt(5, rol);
            resultado = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
            pstmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return resultado;
    }

    public int eliminarUsuarioPorNombreCompleto(String nombreCompleto) {
        int resultado = 0;
        Connection conexion = null;
        String query = "DELETE FROM USUARIO WHERE NOMBRE_COMPLETO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nombreCompleto);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ese nombre completo.");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int modificarUsuario(String nombreCompleto, String nombreUsuario, String contrasena, String email, int rol) {
        int resultado = 0;
        Connection conexion = null;
        String query = "UPDATE USUARIO SET NOMBRE_USUARIO = ?, CONTRASENA = ?, EMAIL = ?, ROL = ? WHERE ID_USUARIO = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contrasena);
            pstmt.setString(3, email);
            pstmt.setInt(4, rol);
            resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Usuario modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ese ID.");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public boolean validarUsuario(String nombreUsuario, String contrasena) {
        boolean usuarioValido = false;
        Connection conexion = null;
        String query = "SELECT COUNT(*) FROM USUARIO WHERE NOMBRE_USUARIO = ? AND CONTRASENA = ?";
        try {
            conexion = BaseDatos.getConnection();
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    usuarioValido = true;
                    JOptionPane.showMessageDialog(null, "Usuario validado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
                }
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarioValido;
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        int resultadoAgregar = usuario.agregarUsuario("Patricia", "patty", "patty", "correo@example.com", 1);
        int resultadoEliminar = usuario.eliminarUsuarioPorNombreCompleto("Patricia");
        int resultadoModificar = usuario.modificarUsuario("Patricia", "Patty", "Patty", "patricia@gmail.com", 1);
        boolean usuarioValido = usuario.validarUsuario("Patty", "Patty");
    }
}