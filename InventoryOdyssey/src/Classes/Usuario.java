package Classes;

import java.util.Date;

public class Usuario extends Persona{
    public String tipoUsuario = null;
    public String nombre_usuario = null;
    private String password = null;

    public Usuario() {
    }
    public Usuario(String nombre, String contraseña){
        nombre_usuario = nombre;
        password = contraseña;
    }
    public Usuario(String nombre, int indetificacion, int telefono, Date edad, String correo, String direccion, String tipoUsuario, String nombre_usuario, String password) {
        super(nombre, indetificacion, telefono, edad, correo, direccion);
        this.tipoUsuario = tipoUsuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public String getTipoUsuario() {//Getters and Setters
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
