package Classes;

import java.util.Date;

public class Compras {
    Date fechaCompra = null;
    Producto producto = new Producto();
    int cantidad = 0;
    float precio = 0f;
    Proveedor proveedor = new Proveedor();
    String numeroFactura = "";
    float valorTotal = 0f;

    public Compras() {
    }

    public Compras(Date fechaCompra, Producto producto, int cantidad, float precio, Proveedor proveedor, String numeroFactura, float valorTotal) {
        this.fechaCompra = fechaCompra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
        this.numeroFactura = numeroFactura;
        this.valorTotal = valorTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
