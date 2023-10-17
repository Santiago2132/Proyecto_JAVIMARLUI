package Classes;

import java.util.Date;
import java.util.LinkedList;

public class Bodeguero extends Usuario {

    public Bodeguero() {
    }

    public Bodeguero(String nombre, int identificacion, int telefono, Date edad, String correo, String direccion, int tipoUsuario, String nombre_usuario, String password, int ventas) {
        super(nombre, identificacion, telefono, edad, correo, direccion, tipoUsuario, nombre_usuario, password, ventas);
    }

    // Métodos específicos de Bodeguero
    public boolean agregarProducto(Producto producto) {
        // Implementa la lógica para agregar un producto cuando tengas la base de datos
        return false;
    }

    public boolean agregarProductos(LinkedList<Producto> productos) {
        // Implementa la lógica para agregar varios productos cuando tengas la base de datos
        return false;
    }
}