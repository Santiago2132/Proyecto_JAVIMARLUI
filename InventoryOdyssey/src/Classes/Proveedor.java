package Classes;

import Structures.LinkedList;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String nombreEmpresa;
    private int nitEmpresa;
    private String telefono;
    private String email;
    private int tipo;

    // Constructores, getters y setters (omítelos para brevedad)


    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombre, String nombreEmpresa, int nitEmpresa, String telefono, String email, int tipo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ID Proveedor: " + idProveedor +
                ", Nombre: " + nombre +
                ", Nombre de Empresa: " + nombreEmpresa +
                ", NIT de Empresa: " + nitEmpresa +
                ", Teléfono: " + telefono +
                ", Email: " + email +
                ", Tipo: " + tipo;
    }

}
