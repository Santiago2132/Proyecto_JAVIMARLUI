package Classes;

public class Producto {

    int idProducto = 0;
    String nombre = "";
    double precioCosto = 0;
    double precioVenta = 0;
    float procentajeIva = 0.19F;//Porcentaje de iva fijo
    String descripcion = "";
    int garantiaMeses = 0; //Depende del producto
    int cantidad = 0;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, double precioCosto, double precioVenta, float procentajeIva, String descripcion, int garantiaMeses, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.procentajeIva = procentajeIva;
        this.descripcion = descripcion;
        this.garantiaMeses = garantiaMeses;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getProcentajeIva() {
        return procentajeIva;
    }

    public void setProcentajeIva(float procentajeIva) {
        this.procentajeIva = procentajeIva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
