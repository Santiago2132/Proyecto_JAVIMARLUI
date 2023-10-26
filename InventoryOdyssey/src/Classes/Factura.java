package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private String nombreCliente;
    private int identificacion;
    private int telefono;
    private String correo;
    private String nombreVendedor;
    private ArrayList<Producto> detalleProductos;
    private double valorTotal;
    private double porcentajeDescuento;

    public Factura() {
    }

    public Factura(Date fecha, String nombreCliente, int identificacion, int telefono, String correo, String nombreVendedor, ArrayList<Producto> detalleProductos, double valorTotal, double porcentajeDescuento) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.nombreVendedor = nombreVendedor;
        this.detalleProductos = detalleProductos;
        this.valorTotal = valorTotal;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Getters y setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public ArrayList<Producto> getDetalleProductos() {
        return detalleProductos;
    }

    public void setDetalleProductos(ArrayList<Producto> detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
