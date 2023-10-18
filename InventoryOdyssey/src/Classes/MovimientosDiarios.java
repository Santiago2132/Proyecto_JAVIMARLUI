package Classes;

import java.util.ArrayList;
import java.util.Date;

public class MovimientosDiarios {
    private ArrayList<Compras> registroCompras;
    private ArrayList<Factura> registroVentas;

    public MovimientosDiarios() {
        registroCompras = new ArrayList<>();
        registroVentas = new ArrayList<>();
    }

    public void registrarCompra(Compras compra) {
        registroCompras.add(compra);
    }

    public void registrarVenta(Factura factura) {
        registroVentas.add(factura);
    }

    public ArrayList<Compras> getRegistroCompras() {
        return registroCompras;
    }

    public ArrayList<Factura> getRegistroVentas() {
        return registroVentas;
    }

    public ArrayList<Object> consultarMovimientos(Date fecha) {
        ArrayList<Object> movimientos = new ArrayList<>();


        for (Compras compra : registroCompras) {
            if (compra.getFechaCompra().equals(fecha)) {
                movimientos.add(compra);
            }
        }


        for (Factura factura : registroVentas) {
            if (factura.getFecha().equals(fecha)) {
                movimientos.add(factura);
            }
        }

        return movimientos;
    }
}
