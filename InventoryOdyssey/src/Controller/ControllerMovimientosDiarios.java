package Controller;

import Classes.Compras;
import Classes.Factura;
import Classes.MovimientosDiarios;
import java.util.ArrayList;
import java.util.Date;

public class ControllerMovimientosDiarios {
    private MovimientosDiarios movimientosDiarios;

    public ControllerMovimientosDiarios() {
        movimientosDiarios = new MovimientosDiarios();
    }

    public void registrarCompra(Compras compra) {
        movimientosDiarios.registrarCompra(compra);
    }

    public void registrarVenta(Factura factura) {
        movimientosDiarios.registrarVenta(factura);
    }

    public ArrayList<Compras> getRegistroCompras() {
        return movimientosDiarios.getRegistroCompras();
    }

    public ArrayList<Factura> getRegistroVentas() {
        return movimientosDiarios.getRegistroVentas();
    }

    public ArrayList<Object> consultarMovimientosDiarios(Date fecha) {
        return movimientosDiarios.consultarMovimientos(fecha);
    }
}
