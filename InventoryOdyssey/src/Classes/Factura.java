package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    Date fecha = new Date();
    String nombreCliente = "";
    int identificacion = 0;//ID
    int telefono = 0;
    String correo = "";
    String nombreVendedor = "";
    ArrayList detalleProductos = new ArrayList<Producto>();
    float valorTotal = 0f;
    float porcentajeDescuento = 0f;

    public Factura() {
    }

    public Factura(Date fecha, String nombreCliente, int identificacion, int telefono, String correo, String nombreVendedor, ArrayList detalleProductos, float valorTotal, float porcentajeDescuento) {
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

    public ArrayList getDetalleProductos() {
        return detalleProductos;
    }

    public void setDetalleProductos(ArrayList detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
