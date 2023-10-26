package Classes;

public class UserM {
    public int idUsuario;
    public String nombreCompleto;
    public String nombreUsuario;
    public String contrasena;
    public String email;
    public int rol;

    public UserM() {
    }

    public UserM(int idUsuario, String nombreCompleto, String nombreUsuario, String contrasena, String email, int rol) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
        this.rol = rol;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }

    public int getRol() {
        return rol;
    }
}
