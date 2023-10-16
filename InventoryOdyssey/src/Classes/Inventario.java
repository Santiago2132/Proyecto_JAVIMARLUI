package Classes;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public Inventario(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(int idProducto) {
        productos.removeIf(p -> p.getIdProducto() == idProducto);
    }

    public void actualizarCantidad(int idProducto, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                // Suponiendo que "cantidad" es un atributo de Producto
                producto.setCantidad(nuevaCantidad);
                break;
            }
        }
    }

    public void actualizarPrecio(int idProducto, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                producto.setPrecioVenta(nuevoPrecio);
                break;
            }
        }
    }

    public String buscarProducto(String criterio) {
        StringBuilder resultado = new StringBuilder();
        for (Producto producto : productos) {
            if (producto.getNombre().contains(criterio) || producto.getDescripcion().contains(criterio)) {
                resultado.append("Producto: ").append(producto.getNombre())
                        .append(", Cantidad: ").append(producto.getCantidad())
                        .append(", Precio: ").append(producto.getPrecioVenta())
                        .append(", Descripción: ").append(producto.getDescripcion())
                        .append(", ID: ").append(producto.getIdProducto())
                        .append("\n");
            }
        }
        return resultado.toString();
    }
}
