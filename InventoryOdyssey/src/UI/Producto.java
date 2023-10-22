package UI;

public class Producto {
    private String codigo;
    private String nombreProducto;
    private String cantidad;
    private String precioUnitario;
    private String iva;

    public Producto(String codigo, String nombreProducto, String cantidad, String precioUnitario, String iva) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.iva = iva;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public String getIva() {
        return iva;
    }
}

