package Classes;

import java.util.Date;
import java.util.ArrayList;

public class Vendedor extends Usuario {
    private String perfil;

    public Vendedor(String nombre, int identificacion, int telefono, Date edad, String correo, String direccion, int tipoUsuario, String nombre_usuario, String password, int ventas, String perfil) {
        super(nombre, identificacion, telefono, edad, correo, direccion, tipoUsuario, nombre_usuario, password, ventas);
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Vendedor buscarVendedor(int identificacion) {
        // Implementa la lógica para buscar un vendedor por identificación
        return null;
    }

    public void asignarVendedor(Factura factura) {
        // Implementa la lógica para asignar un vendedor a una factura
    }

    public ArrayList<Factura> consultarVentasVendedor(Vendedor vendedor) {
        // Implementa la lógica para consultar las ventas realizadas por un vendedor
        return null;
    }
}
