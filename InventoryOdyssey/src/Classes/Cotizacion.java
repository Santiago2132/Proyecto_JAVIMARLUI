package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Cotizacion {
    private Factura datosFactura;

    public Cotizacion() {
        datosFactura = new Factura();
    }

    public Factura generarCotizacion(Cliente cliente, ArrayList<Producto> productos, Vendedor vendedor) {
        // Configura los datos de la cotización Santiago
        Factura cotizacion = new Factura();
        cotizacion.setFecha(new Date());
        cotizacion.setNombreCliente(cliente.getNombre());
        cotizacion.setIdentificacion(cliente.getIdentificacion()); // Corregir aquí
        cotizacion.setTelefono(cliente.getTelefono());
        cotizacion.setCorreo(cliente.getCorreo());
        cotizacion.setNombreVendedor(vendedor.getNombre());

        // Agrega los productos al detalle de la cotización Santiago
        ArrayList<Producto> detalleProductos = new ArrayList<>();
        float valorTotal = 0f;
        for (Producto producto : productos) {
            detalleProductos.add(producto);
            valorTotal += producto.getPrecioVenta();
        }
        cotizacion.setDetalleProductos(detalleProductos);
        cotizacion.setValorTotal(valorTotal);

        return cotizacion;
    }


}
