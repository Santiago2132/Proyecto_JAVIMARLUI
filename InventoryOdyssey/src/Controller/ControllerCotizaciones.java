package Controller;

import Classes.Cotizacion;
import Classes.Cliente;
import Classes.Producto;
import Classes.Vendedor;
import java.util.ArrayList;
import Classes.Factura;
import java.util.Date;

public class ControllerCotizaciones {
    public Factura generarCotizacion(Cliente cliente, ArrayList<Producto> productos, Vendedor vendedor) {
        // Crea una instancia de Cotizacion y utiliza su método para generar la cotización, Mire Santiago
        Cotizacion cotizacion = new Cotizacion();
        Factura facturaGenerada = cotizacion.generarCotizacion(cliente, productos, vendedor);
        return facturaGenerada;
    }
}
