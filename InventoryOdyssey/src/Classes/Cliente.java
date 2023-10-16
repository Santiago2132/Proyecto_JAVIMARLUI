package Classes;

import java.util.Date;

public class Cliente extends Persona{
    public Cliente(String nombre, int indetificacion, int telefono, Date edad, String correo, String direccion) {
        super(nombre, indetificacion, telefono, edad, correo, direccion);
    }

    public Cliente() {
    }

}
