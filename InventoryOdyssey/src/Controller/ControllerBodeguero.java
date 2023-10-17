package Controller;

import Classes.Inventario;
import Classes.Producto;
import Structures.LinkedList;

public class ControllerBodeguero {
    private Inventario inventario;

    public ControllerBodeguero(Inventario inventario) {
        this.inventario = inventario;
    }

    public boolean agregarProducto(Producto producto) {
        inventario.agregarProducto(producto);
        return true;
    }

    public boolean modificarProducto(Producto producto) {
        inventario.actualizarCantidad(producto.getIdProducto(), producto.getCantidad());
        inventario.actualizarPrecio(producto.getIdProducto(), producto.getPrecioVenta());
        return true;
    }
}
