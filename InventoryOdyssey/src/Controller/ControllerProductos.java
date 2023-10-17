package Controller;

import Classes.Producto;

import java.util.ArrayList;

public class ControllerProductos {
    private ArrayList<Producto> listaProductos;

    public ControllerProductos() {
        listaProductos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto producto) {
        return listaProductos.add(producto);
    }

    public boolean modificarProducto(int idProducto, Producto nuevoProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProducto) {
                listaProductos.remove(producto);
                return listaProductos.add(nuevoProducto);
            }
        }
        return false; // No se encontró el producto con el ID dado
    }

    public boolean eliminarProducto(int idProducto) {
        Producto productoAEliminar = null;
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProducto) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            return listaProductos.remove(productoAEliminar);
        }
        return false; // No se encontró el producto con el ID dado
    }

    public Producto consultarProducto(int idProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null; // No se encontró el producto con el ID dado
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}
