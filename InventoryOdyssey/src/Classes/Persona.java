package Classes;

import java.util.Date;

public class Persona {
    String nombre = null;
    int identificacion = 0;
    int telefono = 0;
    Date edad = null;
    String correo = null;
    String direccion = null;

    public Persona() {//Constructores
    }
    public Persona(String nombre, int telefono, Date edad, String correo, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }
    public Persona(String nombre, int identificacion, int telefono, Date edad, String correo, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getNombre() {//Getters and Setters
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIndetificacion(int indetificacion) {
        this.identificacion = indetificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getEdad() {
        return edad;
    }

    public void setEdad(Date edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
