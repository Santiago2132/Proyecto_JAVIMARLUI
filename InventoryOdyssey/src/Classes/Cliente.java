package Classes;

import java.util.Date;

public class Cliente extends Persona {
    public Cliente(String nombre, int identificacion, int telefono, Date edad, String correo, String direccion) {
        super(nombre, identificacion, telefono, edad, correo, direccion);
    }

    public Cliente() {
    }
}


