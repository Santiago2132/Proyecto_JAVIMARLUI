package UI;

public class Proveedor {
    private String id;
    private String nombre;
    private String nombreEmpresa;
    private String nitEmpresa;
    private String telefono;
    private String email;
    private String tipo;

    public Proveedor(String id, String nombre, String nombreEmpresa, String nitEmpresa, String telefono, String email, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }

}