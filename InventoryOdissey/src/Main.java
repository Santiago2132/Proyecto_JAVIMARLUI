import Controllers.AdminController;
import Controllers.LoginController;
import Controllers.VendedorController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Ejemplo de uso del controlador de inicio de sesión
        LoginController loginController = new LoginController();
        boolean loginExitoso = loginController.login("usuario", "contrasena");
        System.out.println("Inicio de sesión exitoso: " + loginExitoso);

        // Ejemplo de uso del controlador de administrador
        AdminController adminController = new AdminController();
        adminController.agregarUsuario("Nombre Usuario", "usuario", "contrasena", "administrador");

        // Ejemplo de uso del controlador de vendedor
        VendedorController vendedorController = new VendedorController();
        ResultSet clientes = vendedorController.obtenerClientes();
        while (clientes.next()) {
            String nombreCliente = clientes.getString("nombre");
            String direccionCliente = clientes.getString("direccion");
            System.out.println("Cliente: " + nombreCliente + ", Dirección: " + direccionCliente);
        }
    }
}
